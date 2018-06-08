package com.baidu.tieba.write.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes3.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private h htb;
    private i hvj;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.htb = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bHV() {
                WriteMultiImgsActivity.this.hvj.bIW();
                WriteMultiImgsActivity.this.hvj.nJ(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bHW() {
                WriteMultiImgsActivity.this.hvj.bJb();
                WriteMultiImgsActivity.this.hvj.nJ(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean G(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.hvj.I(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bHX() {
                WriteMultiImgsActivity.this.hvj.bHX();
            }
        });
        setContentView(this.htb.cVB);
        this.hvj = new i(getPageContext(), this.htb, bundle);
        if (this.hvj.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.hvj.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.hvj != null && this.hvj.hvt != null) {
            bundle.putInt("OutState_Current_Index", this.hvj.hvt.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.hvj.bIZ());
            bundle.putSerializable("OutState_Write_Info_Data", this.hvj.atL());
            this.hvj.hvt.nD(true);
            if (this.hvj.bJc() != null) {
                bundle.putString("OutState_Write_Img_Info", this.hvj.bJc().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bIW() {
        if (this.hvj != null) {
            this.hvj.bIW();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.hvj != null) {
            if (1 == this.hvj.bIZ()) {
                ForumWriteData atL = this.hvj.atL();
                if (atL != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, atL.forumId, atL.forumName, null, null, 0, atL.antiData, 13003, false, false, null, false, false, null, null, atL.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", atL.mFrom);
                    writeActivityConfig.setCallFrom(atL.writeCallFrom);
                    writeActivityConfig.setForumLevel(atL.forumLevel);
                    writeActivityConfig.setForumAvatar(atL.avatar);
                    writeActivityConfig.setPrivateThread(atL.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            } else if (2 == this.hvj.bIZ()) {
                Intent intent = new Intent(this, WriteActivity.class);
                intent.putExtra("KEY_WRITE_IMAGES_INFO_STRING", writeImagesInfo.toJsonString());
                intent.setFlags(536870912);
                intent.setFlags(67108864);
                startActivity(intent);
                finish();
                return;
            }
        }
        if (z) {
            if (writeImagesInfo != null) {
                Intent intent2 = new Intent();
                intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, writeImagesInfo.toJsonString());
                if (!w.z(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
                    intent2.putExtra("file_name", writeImagesInfo.getChosedFiles().get(0).extra);
                }
                setResult(-1, intent2);
            } else {
                return;
            }
        } else {
            setResult(0);
        }
        finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.htb != null) {
            this.htb.vC(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hvj != null) {
            this.hvj.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.htb != null) {
            this.htb.onDestroy();
        }
        super.onDestroy();
    }
}
