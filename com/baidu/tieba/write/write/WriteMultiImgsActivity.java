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
    private h jST;
    private i jVd;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.jST = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void czi() {
                WriteMultiImgsActivity.this.jVd.cAk();
                WriteMultiImgsActivity.this.jVd.rZ(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void czj() {
                WriteMultiImgsActivity.this.jVd.cAp();
                WriteMultiImgsActivity.this.jVd.rZ(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean N(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.jVd.P(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void czk() {
                WriteMultiImgsActivity.this.jVd.czk();
            }
        });
        setContentView(this.jST.fhN);
        this.jVd = new i(getPageContext(), this.jST, bundle);
        if (this.jVd.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.jVd.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.jVd != null && this.jVd.jVn != null) {
            bundle.putInt("OutState_Current_Index", this.jVd.jVn.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.jVd.cAn());
            bundle.putSerializable("OutState_Write_Info_Data", this.jVd.bkq());
            this.jVd.jVn.rU(true);
            if (this.jVd.cAq() != null) {
                bundle.putString("OutState_Write_Img_Info", this.jVd.cAq().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cAk() {
        if (this.jVd != null) {
            this.jVd.cAk();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.jVd != null) {
            if (1 == this.jVd.cAn()) {
                ForumWriteData bkq = this.jVd.bkq();
                if (bkq != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, bkq.forumId, bkq.forumName, null, null, 0, bkq.antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, bkq.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", bkq.mFrom);
                    writeActivityConfig.setCallFrom(bkq.writeCallFrom);
                    writeActivityConfig.setForumLevel(bkq.forumLevel);
                    writeActivityConfig.setForumAvatar(bkq.avatar);
                    writeActivityConfig.setPrivateThread(bkq.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.jVd.cAn()) {
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
        if (this.jST != null) {
            this.jST.BP(i);
        }
        this.jVd.jVn.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jVd != null) {
            this.jVd.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.jST != null) {
            this.jST.onDestroy();
        }
        super.onDestroy();
    }
}
