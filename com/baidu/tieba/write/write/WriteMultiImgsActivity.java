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
    private h jSi;
    private i jUs;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.jSi = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cBr() {
                WriteMultiImgsActivity.this.jUs.cCt();
                WriteMultiImgsActivity.this.jUs.sq(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cBs() {
                WriteMultiImgsActivity.this.jUs.cCy();
                WriteMultiImgsActivity.this.jUs.sq(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean P(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.jUs.R(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cBt() {
                WriteMultiImgsActivity.this.jUs.cBt();
            }
        });
        setContentView(this.jSi.fdF);
        this.jUs = new i(getPageContext(), this.jSi, bundle);
        if (this.jUs.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.jUs.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.jUs != null && this.jUs.jUC != null) {
            bundle.putInt("OutState_Current_Index", this.jUs.jUC.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.jUs.cCw());
            bundle.putSerializable("OutState_Write_Info_Data", this.jUs.bmr());
            this.jUs.jUC.sl(true);
            if (this.jUs.cCz() != null) {
                bundle.putString("OutState_Write_Img_Info", this.jUs.cCz().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cCt() {
        if (this.jUs != null) {
            this.jUs.cCt();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.jUs != null) {
            if (1 == this.jUs.cCw()) {
                ForumWriteData bmr = this.jUs.bmr();
                if (bmr != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, bmr.forumId, bmr.forumName, null, null, 0, bmr.antiData, 13003, false, false, null, false, false, null, null, bmr.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", bmr.mFrom);
                    writeActivityConfig.setCallFrom(bmr.writeCallFrom);
                    writeActivityConfig.setForumLevel(bmr.forumLevel);
                    writeActivityConfig.setForumAvatar(bmr.avatar);
                    writeActivityConfig.setPrivateThread(bmr.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            } else if (2 == this.jUs.cCw()) {
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
                if (!v.aa(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
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
        if (this.jSi != null) {
            this.jSi.Do(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jUs != null) {
            this.jUs.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.jSi != null) {
            this.jSi.onDestroy();
        }
        super.onDestroy();
    }
}
