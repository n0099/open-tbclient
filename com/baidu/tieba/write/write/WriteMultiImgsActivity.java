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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes3.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private h ibp;
    private i idB;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.ibp = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bQs() {
                WriteMultiImgsActivity.this.idB.bRt();
                WriteMultiImgsActivity.this.idB.oL(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bQt() {
                WriteMultiImgsActivity.this.idB.bRy();
                WriteMultiImgsActivity.this.idB.oL(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean G(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.idB.I(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bQu() {
                WriteMultiImgsActivity.this.idB.bQu();
            }
        });
        setContentView(this.ibp.dvt);
        this.idB = new i(getPageContext(), this.ibp, bundle);
        if (this.idB.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.idB.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.idB != null && this.idB.idL != null) {
            bundle.putInt("OutState_Current_Index", this.idB.idL.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.idB.bRw());
            bundle.putSerializable("OutState_Write_Info_Data", this.idB.aCo());
            this.idB.idL.oG(true);
            if (this.idB.bRz() != null) {
                bundle.putString("OutState_Write_Img_Info", this.idB.bRz().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bRt() {
        if (this.idB != null) {
            this.idB.bRt();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.idB != null) {
            if (1 == this.idB.bRw()) {
                ForumWriteData aCo = this.idB.aCo();
                if (aCo != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, aCo.forumId, aCo.forumName, null, null, 0, aCo.antiData, 13003, false, false, null, false, false, null, null, aCo.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", aCo.mFrom);
                    writeActivityConfig.setCallFrom(aCo.writeCallFrom);
                    writeActivityConfig.setForumLevel(aCo.forumLevel);
                    writeActivityConfig.setForumAvatar(aCo.avatar);
                    writeActivityConfig.setPrivateThread(aCo.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            } else if (2 == this.idB.bRw()) {
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
                if (!v.I(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
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
        if (this.ibp != null) {
            this.ibp.xM(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.idB != null) {
            this.idB.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.ibp != null) {
            this.ibp.onDestroy();
        }
        super.onDestroy();
    }
}
