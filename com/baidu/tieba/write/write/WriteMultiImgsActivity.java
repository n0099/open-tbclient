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
/* loaded from: classes13.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private h kSh;
    private i kUq;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.kSh = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cVE() {
                WriteMultiImgsActivity.this.kUq.cWH();
                WriteMultiImgsActivity.this.kUq.tW(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cVF() {
                WriteMultiImgsActivity.this.kUq.cWM();
                WriteMultiImgsActivity.this.kUq.tW(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean N(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.kUq.P(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cVG() {
                WriteMultiImgsActivity.this.kUq.cVG();
            }
        });
        setContentView(this.kSh.gbN);
        this.kUq = new i(getPageContext(), this.kSh, bundle);
        if (this.kUq.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.kUq.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.kUq != null && this.kUq.kUA != null) {
            bundle.putInt("OutState_Current_Index", this.kUq.kUA.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.kUq.cWK());
            bundle.putSerializable("OutState_Write_Info_Data", this.kUq.bEu());
            this.kUq.kUA.tR(true);
            if (this.kUq.cWN() != null) {
                bundle.putString("OutState_Write_Img_Info", this.kUq.cWN().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cWH() {
        if (this.kUq != null) {
            this.kUq.cWH();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.kUq != null) {
            if (1 == this.kUq.cWK()) {
                ForumWriteData bEu = this.kUq.bEu();
                if (bEu != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, bEu.forumId, bEu.forumName, null, null, 0, bEu.antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, bEu.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", bEu.mFrom);
                    writeActivityConfig.setCallFrom(bEu.writeCallFrom);
                    writeActivityConfig.setForumLevel(bEu.forumLevel);
                    writeActivityConfig.setForumAvatar(bEu.avatar);
                    writeActivityConfig.setPrivateThread(bEu.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.kUq.cWK()) {
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
        if (this.kSh != null) {
            this.kSh.Ew(i);
        }
        this.kUq.kUA.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.kUq != null) {
            this.kUq.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.kSh != null) {
            this.kSh.onDestroy();
        }
        super.onDestroy();
    }
}
