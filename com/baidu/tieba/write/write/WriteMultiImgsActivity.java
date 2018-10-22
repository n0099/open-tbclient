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
    private h hOd;
    private i hQm;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hOd = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bNp() {
                WriteMultiImgsActivity.this.hQm.bOq();
                WriteMultiImgsActivity.this.hQm.or(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bNq() {
                WriteMultiImgsActivity.this.hQm.bOv();
                WriteMultiImgsActivity.this.hQm.or(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean G(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.hQm.I(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bNr() {
                WriteMultiImgsActivity.this.hQm.bNr();
            }
        });
        setContentView(this.hOd.dkp);
        this.hQm = new i(getPageContext(), this.hOd, bundle);
        if (this.hQm.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.hQm.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.hQm != null && this.hQm.hQw != null) {
            bundle.putInt("OutState_Current_Index", this.hQm.hQw.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.hQm.bOt());
            bundle.putSerializable("OutState_Write_Info_Data", this.hQm.azV());
            this.hQm.hQw.om(true);
            if (this.hQm.bOw() != null) {
                bundle.putString("OutState_Write_Img_Info", this.hQm.bOw().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bOq() {
        if (this.hQm != null) {
            this.hQm.bOq();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.hQm != null) {
            if (1 == this.hQm.bOt()) {
                ForumWriteData azV = this.hQm.azV();
                if (azV != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, azV.forumId, azV.forumName, null, null, 0, azV.antiData, 13003, false, false, null, false, false, null, null, azV.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", azV.mFrom);
                    writeActivityConfig.setCallFrom(azV.writeCallFrom);
                    writeActivityConfig.setForumLevel(azV.forumLevel);
                    writeActivityConfig.setForumAvatar(azV.avatar);
                    writeActivityConfig.setPrivateThread(azV.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            } else if (2 == this.hQm.bOt()) {
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
                if (!v.J(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
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
        if (this.hOd != null) {
            this.hOd.wH(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hQm != null) {
            this.hQm.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.hOd != null) {
            this.hOd.onDestroy();
        }
        super.onDestroy();
    }
}
