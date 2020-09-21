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
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes3.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private j ndY;
    private k ngN;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.ndY = new j(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dLz() {
                WriteMultiImgsActivity.this.ngN.dMX();
                WriteMultiImgsActivity.this.ngN.xF(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dLA() {
                WriteMultiImgsActivity.this.ngN.dNc();
                WriteMultiImgsActivity.this.ngN.xF(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean U(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.ngN.W(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dLB() {
                WriteMultiImgsActivity.this.ngN.dLB();
            }
        });
        setContentView(this.ndY.hNd);
        this.ngN = new k(getPageContext(), this.ndY, bundle);
        if (this.ngN.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.ngN.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.ngN != null && this.ngN.ngX != null) {
            bundle.putInt("OutState_Current_Index", this.ngN.ngX.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.ngN.dNa());
            bundle.putSerializable("OutState_Write_Info_Data", this.ngN.cpN());
            this.ngN.ngX.xz(true);
            if (this.ngN.dNd() != null) {
                bundle.putString("OutState_Write_Img_Info", this.ngN.dNd().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dMX() {
        if (this.ngN != null) {
            this.ngN.dMX();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.ngN != null) {
            if (1 == this.ngN.dNa()) {
                ForumWriteData cpN = this.ngN.cpN();
                if (cpN != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, cpN.forumId, cpN.forumName, null, null, 0, cpN.antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, cpN.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", cpN.mFrom);
                    writeActivityConfig.setCallFrom(cpN.writeCallFrom);
                    writeActivityConfig.setForumLevel(cpN.forumLevel);
                    writeActivityConfig.setForumAvatar(cpN.avatar);
                    writeActivityConfig.setPrivateThread(cpN.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    writeActivityConfig.setFrsTabInfo(cpN.frsTabInfo);
                    writeActivityConfig.setProfessionZone(cpN.defaultZone);
                    writeActivityConfig.setForumDir(cpN.firstDir, cpN.secondDir);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.ngN.dNa()) {
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
                if (!y.isEmpty(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
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
        if (this.ndY != null) {
            this.ndY.Ky(i);
        }
        this.ngN.ngX.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.ngN != null) {
            this.ngN.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.ndY != null) {
            this.ndY.onDestroy();
        }
        super.onDestroy();
    }
}
