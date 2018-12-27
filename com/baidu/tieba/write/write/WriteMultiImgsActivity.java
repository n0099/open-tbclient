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
    private h iai;
    private i icr;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.iai = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bPK() {
                WriteMultiImgsActivity.this.icr.bQL();
                WriteMultiImgsActivity.this.icr.oK(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bPL() {
                WriteMultiImgsActivity.this.icr.bQQ();
                WriteMultiImgsActivity.this.icr.oK(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean G(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.icr.I(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bPM() {
                WriteMultiImgsActivity.this.icr.bPM();
            }
        });
        setContentView(this.iai.duK);
        this.icr = new i(getPageContext(), this.iai, bundle);
        if (this.icr.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.icr.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.icr != null && this.icr.icB != null) {
            bundle.putInt("OutState_Current_Index", this.icr.icB.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.icr.bQO());
            bundle.putSerializable("OutState_Write_Info_Data", this.icr.aBR());
            this.icr.icB.oF(true);
            if (this.icr.bQR() != null) {
                bundle.putString("OutState_Write_Img_Info", this.icr.bQR().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bQL() {
        if (this.icr != null) {
            this.icr.bQL();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.icr != null) {
            if (1 == this.icr.bQO()) {
                ForumWriteData aBR = this.icr.aBR();
                if (aBR != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, aBR.forumId, aBR.forumName, null, null, 0, aBR.antiData, 13003, false, false, null, false, false, null, null, aBR.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", aBR.mFrom);
                    writeActivityConfig.setCallFrom(aBR.writeCallFrom);
                    writeActivityConfig.setForumLevel(aBR.forumLevel);
                    writeActivityConfig.setForumAvatar(aBR.avatar);
                    writeActivityConfig.setPrivateThread(aBR.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            } else if (2 == this.icr.bQO()) {
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
        if (this.iai != null) {
            this.iai.xK(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.icr != null) {
            this.icr.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.iai != null) {
            this.iai.onDestroy();
        }
        super.onDestroy();
    }
}
