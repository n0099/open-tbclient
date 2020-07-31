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
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes3.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private h mAX;
    private i mDt;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mAX = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dvR() {
                WriteMultiImgsActivity.this.mDt.dxb();
                WriteMultiImgsActivity.this.mDt.wE(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dvS() {
                WriteMultiImgsActivity.this.mDt.dxg();
                WriteMultiImgsActivity.this.mDt.wE(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean V(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.mDt.X(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dvT() {
                WriteMultiImgsActivity.this.mDt.dvT();
            }
        });
        setContentView(this.mAX.hsG);
        this.mDt = new i(getPageContext(), this.mAX, bundle);
        if (this.mDt.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.mDt.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.mDt != null && this.mDt.mDF != null) {
            bundle.putInt("OutState_Current_Index", this.mDt.mDF.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.mDt.dxe());
            bundle.putSerializable("OutState_Write_Info_Data", this.mDt.ccd());
            this.mDt.mDF.wy(true);
            if (this.mDt.dxh() != null) {
                bundle.putString("OutState_Write_Img_Info", this.mDt.dxh().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dxb() {
        if (this.mDt != null) {
            this.mDt.dxb();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mDt != null) {
            if (1 == this.mDt.dxe()) {
                ForumWriteData ccd = this.mDt.ccd();
                if (ccd != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, ccd.forumId, ccd.forumName, null, null, 0, ccd.antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, ccd.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", ccd.mFrom);
                    writeActivityConfig.setCallFrom(ccd.writeCallFrom);
                    writeActivityConfig.setForumLevel(ccd.forumLevel);
                    writeActivityConfig.setForumAvatar(ccd.avatar);
                    writeActivityConfig.setPrivateThread(ccd.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    writeActivityConfig.setFrsTabInfo(ccd.frsTabInfo);
                    writeActivityConfig.setProfessionZone(ccd.defaultZone);
                    writeActivityConfig.setForumDir(ccd.firstDir, ccd.secondDir);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.mDt.dxe()) {
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
                if (!x.isEmpty(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
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
        if (this.mAX != null) {
            this.mAX.Ht(i);
        }
        this.mDt.mDF.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mDt != null) {
            this.mDt.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.mAX != null) {
            this.mAX.onDestroy();
        }
        super.onDestroy();
    }
}
