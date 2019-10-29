package com.baidu.tieba.write.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes3.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private h jTK;
    private i jVU;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.jTK = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void czk() {
                WriteMultiImgsActivity.this.jVU.cAm();
                WriteMultiImgsActivity.this.jVU.rZ(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void czl() {
                WriteMultiImgsActivity.this.jVU.cAr();
                WriteMultiImgsActivity.this.jVU.rZ(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean N(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.jVU.P(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void czm() {
                WriteMultiImgsActivity.this.jVU.czm();
            }
        });
        setContentView(this.jTK.fiG);
        this.jVU = new i(getPageContext(), this.jTK, bundle);
        if (this.jVU.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.jVU.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.jVU != null && this.jVU.jWe != null) {
            bundle.putInt("OutState_Current_Index", this.jVU.jWe.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.jVU.cAp());
            bundle.putSerializable("OutState_Write_Info_Data", this.jVU.bks());
            this.jVU.jWe.rU(true);
            if (this.jVU.cAs() != null) {
                bundle.putString("OutState_Write_Img_Info", this.jVU.cAs().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cAm() {
        if (this.jVU != null) {
            this.jVU.cAm();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.jVU != null) {
            if (1 == this.jVU.cAp()) {
                ForumWriteData bks = this.jVU.bks();
                if (bks != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, bks.forumId, bks.forumName, null, null, 0, bks.antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, bks.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", bks.mFrom);
                    writeActivityConfig.setCallFrom(bks.writeCallFrom);
                    writeActivityConfig.setForumLevel(bks.forumLevel);
                    writeActivityConfig.setForumAvatar(bks.avatar);
                    writeActivityConfig.setPrivateThread(bks.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.jVU.cAp()) {
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
                intent2.putExtra("album_result", writeImagesInfo.toJsonString());
                if (!v.isEmpty(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
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
        if (this.jTK != null) {
            this.jTK.BQ(i);
        }
        this.jVU.jWe.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jVU != null) {
            this.jVU.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.jTK != null) {
            this.jTK.onDestroy();
        }
        super.onDestroy();
    }
}
