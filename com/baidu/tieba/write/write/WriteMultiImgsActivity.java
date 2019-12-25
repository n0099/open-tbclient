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
/* loaded from: classes10.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private h kNH;
    private i kPQ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.kNH = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cTi() {
                WriteMultiImgsActivity.this.kPQ.cUl();
                WriteMultiImgsActivity.this.kPQ.tG(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cTj() {
                WriteMultiImgsActivity.this.kPQ.cUq();
                WriteMultiImgsActivity.this.kPQ.tG(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean N(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.kPQ.P(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cTk() {
                WriteMultiImgsActivity.this.kPQ.cTk();
            }
        });
        setContentView(this.kNH.fWp);
        this.kPQ = new i(getPageContext(), this.kNH, bundle);
        if (this.kPQ.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.kPQ.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.kPQ != null && this.kPQ.kQa != null) {
            bundle.putInt("OutState_Current_Index", this.kPQ.kQa.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.kPQ.cUo());
            bundle.putSerializable("OutState_Write_Info_Data", this.kPQ.bBM());
            this.kPQ.kQa.tB(true);
            if (this.kPQ.cUr() != null) {
                bundle.putString("OutState_Write_Img_Info", this.kPQ.cUr().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cUl() {
        if (this.kPQ != null) {
            this.kPQ.cUl();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.kPQ != null) {
            if (1 == this.kPQ.cUo()) {
                ForumWriteData bBM = this.kPQ.bBM();
                if (bBM != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, bBM.forumId, bBM.forumName, null, null, 0, bBM.antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, bBM.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", bBM.mFrom);
                    writeActivityConfig.setCallFrom(bBM.writeCallFrom);
                    writeActivityConfig.setForumLevel(bBM.forumLevel);
                    writeActivityConfig.setForumAvatar(bBM.avatar);
                    writeActivityConfig.setPrivateThread(bBM.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.kPQ.cUo()) {
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
        if (this.kNH != null) {
            this.kNH.Em(i);
        }
        this.kPQ.kQa.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.kPQ != null) {
            this.kPQ.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.kNH != null) {
            this.kNH.onDestroy();
        }
        super.onDestroy();
    }
}
