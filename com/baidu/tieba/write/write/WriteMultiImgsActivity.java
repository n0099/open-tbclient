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
    private j nNr;
    private k nQh;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.nNr = new j(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dUS() {
                WriteMultiImgsActivity.this.nQh.dWq();
                WriteMultiImgsActivity.this.nQh.yT(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dUT() {
                WriteMultiImgsActivity.this.nQh.dWv();
                WriteMultiImgsActivity.this.nQh.yT(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean U(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.nQh.W(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dUU() {
                WriteMultiImgsActivity.this.nQh.dUU();
            }
        });
        setContentView(this.nNr.ivl);
        this.nQh = new k(getPageContext(), this.nNr, bundle);
        if (this.nQh.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.nQh.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.nQh != null && this.nQh.nQr != null) {
            bundle.putInt("OutState_Current_Index", this.nQh.nQr.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.nQh.dWt());
            bundle.putSerializable("OutState_Write_Info_Data", this.nQh.cyw());
            this.nQh.nQr.yN(true);
            if (this.nQh.dWw() != null) {
                bundle.putString("OutState_Write_Img_Info", this.nQh.dWw().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dWq() {
        if (this.nQh != null) {
            this.nQh.dWq();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.nQh != null) {
            if (1 == this.nQh.dWt()) {
                ForumWriteData cyw = this.nQh.cyw();
                if (cyw != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, cyw.forumId, cyw.forumName, null, null, 0, cyw.antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, cyw.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", cyw.mFrom);
                    writeActivityConfig.setCallFrom(cyw.writeCallFrom);
                    writeActivityConfig.setForumLevel(cyw.forumLevel);
                    writeActivityConfig.setForumAvatar(cyw.avatar);
                    writeActivityConfig.setPrivateThread(cyw.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    writeActivityConfig.setFrsTabInfo(cyw.frsTabInfo);
                    writeActivityConfig.setProfessionZone(cyw.defaultZone);
                    writeActivityConfig.setForumDir(cyw.firstDir, cyw.secondDir);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.nQh.dWt()) {
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
        if (this.nNr != null) {
            this.nNr.Mm(i);
        }
        this.nQh.nQr.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.nQh != null) {
            this.nQh.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.nNr != null) {
            this.nNr.onDestroy();
        }
        super.onDestroy();
    }
}
