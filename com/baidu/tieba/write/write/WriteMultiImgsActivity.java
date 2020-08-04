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
    private h mAZ;
    private i mDv;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mAZ = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dvS() {
                WriteMultiImgsActivity.this.mDv.dxc();
                WriteMultiImgsActivity.this.mDv.wE(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dvT() {
                WriteMultiImgsActivity.this.mDv.dxh();
                WriteMultiImgsActivity.this.mDv.wE(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean V(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.mDv.X(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dvU() {
                WriteMultiImgsActivity.this.mDv.dvU();
            }
        });
        setContentView(this.mAZ.hsG);
        this.mDv = new i(getPageContext(), this.mAZ, bundle);
        if (this.mDv.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.mDv.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.mDv != null && this.mDv.mDH != null) {
            bundle.putInt("OutState_Current_Index", this.mDv.mDH.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.mDv.dxf());
            bundle.putSerializable("OutState_Write_Info_Data", this.mDv.ccd());
            this.mDv.mDH.wy(true);
            if (this.mDv.dxi() != null) {
                bundle.putString("OutState_Write_Img_Info", this.mDv.dxi().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dxc() {
        if (this.mDv != null) {
            this.mDv.dxc();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mDv != null) {
            if (1 == this.mDv.dxf()) {
                ForumWriteData ccd = this.mDv.ccd();
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
            } else if (2 == this.mDv.dxf()) {
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
        if (this.mAZ != null) {
            this.mAZ.Ht(i);
        }
        this.mDv.mDH.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mDv != null) {
            this.mDv.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.mAZ != null) {
            this.mAZ.onDestroy();
        }
        super.onDestroy();
    }
}
