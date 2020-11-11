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
    private j nLQ;
    private k nOE;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.nLQ = new j(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dUT() {
                WriteMultiImgsActivity.this.nOE.dWr();
                WriteMultiImgsActivity.this.nOE.yM(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dUU() {
                WriteMultiImgsActivity.this.nOE.dWw();
                WriteMultiImgsActivity.this.nOE.yM(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean U(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.nOE.W(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dUV() {
                WriteMultiImgsActivity.this.nOE.dUV();
            }
        });
        setContentView(this.nLQ.iux);
        this.nOE = new k(getPageContext(), this.nLQ, bundle);
        if (this.nOE.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.nOE.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.nOE != null && this.nOE.nOO != null) {
            bundle.putInt("OutState_Current_Index", this.nOE.nOO.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.nOE.dWu());
            bundle.putSerializable("OutState_Write_Info_Data", this.nOE.cyT());
            this.nOE.nOO.yG(true);
            if (this.nOE.dWx() != null) {
                bundle.putString("OutState_Write_Img_Info", this.nOE.dWx().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dWr() {
        if (this.nOE != null) {
            this.nOE.dWr();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.nOE != null) {
            if (1 == this.nOE.dWu()) {
                ForumWriteData cyT = this.nOE.cyT();
                if (cyT != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, cyT.forumId, cyT.forumName, null, null, 0, cyT.antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, cyT.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", cyT.mFrom);
                    writeActivityConfig.setCallFrom(cyT.writeCallFrom);
                    writeActivityConfig.setForumLevel(cyT.forumLevel);
                    writeActivityConfig.setForumAvatar(cyT.avatar);
                    writeActivityConfig.setPrivateThread(cyT.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    writeActivityConfig.setFrsTabInfo(cyT.frsTabInfo);
                    writeActivityConfig.setProfessionZone(cyT.defaultZone);
                    writeActivityConfig.setForumDir(cyT.firstDir, cyT.secondDir);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.nOE.dWu()) {
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
        if (this.nLQ != null) {
            this.nLQ.LJ(i);
        }
        this.nOE.nOO.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.nOE != null) {
            this.nOE.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.nLQ != null) {
            this.nLQ.onDestroy();
        }
        super.onDestroy();
    }
}
