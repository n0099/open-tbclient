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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes2.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private h msY;
    private i mvr;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.msY = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dsF() {
                WriteMultiImgsActivity.this.mvr.dtP();
                WriteMultiImgsActivity.this.mvr.vZ(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dsG() {
                WriteMultiImgsActivity.this.mvr.dtU();
                WriteMultiImgsActivity.this.mvr.vZ(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean S(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.mvr.U(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dsH() {
                WriteMultiImgsActivity.this.mvr.dsH();
            }
        });
        setContentView(this.msY.hmU);
        this.mvr = new i(getPageContext(), this.msY, bundle);
        if (this.mvr.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.mvr.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.mvr != null && this.mvr.mvB != null) {
            bundle.putInt("OutState_Current_Index", this.mvr.mvB.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.mvr.dtS());
            bundle.putSerializable("OutState_Write_Info_Data", this.mvr.bYG());
            this.mvr.mvB.vT(true);
            if (this.mvr.dtV() != null) {
                bundle.putString("OutState_Write_Img_Info", this.mvr.dtV().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dtP() {
        if (this.mvr != null) {
            this.mvr.dtP();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mvr != null) {
            if (1 == this.mvr.dtS()) {
                ForumWriteData bYG = this.mvr.bYG();
                if (bYG != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, bYG.forumId, bYG.forumName, null, null, 0, bYG.antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, bYG.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", bYG.mFrom);
                    writeActivityConfig.setCallFrom(bYG.writeCallFrom);
                    writeActivityConfig.setForumLevel(bYG.forumLevel);
                    writeActivityConfig.setForumAvatar(bYG.avatar);
                    writeActivityConfig.setPrivateThread(bYG.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    writeActivityConfig.setFrsTabInfo(bYG.frsTabInfo);
                    writeActivityConfig.setProfessionZone(bYG.defaultZone);
                    writeActivityConfig.setForumDir(bYG.firstDir, bYG.secondDir);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.mvr.dtS()) {
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
                if (!w.isEmpty(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
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
        if (this.msY != null) {
            this.msY.GY(i);
        }
        this.mvr.mvB.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mvr != null) {
            this.mvr.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.msY != null) {
            this.msY.onDestroy();
        }
        super.onDestroy();
    }
}
