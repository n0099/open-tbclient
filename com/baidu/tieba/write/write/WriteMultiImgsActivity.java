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
/* loaded from: classes2.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private h lYn;
    private i maA;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.lYn = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void don() {
                WriteMultiImgsActivity.this.maA.dpq();
                WriteMultiImgsActivity.this.maA.vF(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void doo() {
                WriteMultiImgsActivity.this.maA.dpv();
                WriteMultiImgsActivity.this.maA.vF(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean S(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.maA.U(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dop() {
                WriteMultiImgsActivity.this.maA.dop();
            }
        });
        setContentView(this.lYn.haJ);
        this.maA = new i(getPageContext(), this.lYn, bundle);
        if (this.maA.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.maA.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.maA != null && this.maA.maK != null) {
            bundle.putInt("OutState_Current_Index", this.maA.maK.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.maA.dpt());
            bundle.putSerializable("OutState_Write_Info_Data", this.maA.bVy());
            this.maA.maK.vA(true);
            if (this.maA.dpw() != null) {
                bundle.putString("OutState_Write_Img_Info", this.maA.dpw().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dpq() {
        if (this.maA != null) {
            this.maA.dpq();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.maA != null) {
            if (1 == this.maA.dpt()) {
                ForumWriteData bVy = this.maA.bVy();
                if (bVy != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, bVy.forumId, bVy.forumName, null, null, 0, bVy.antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, bVy.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", bVy.mFrom);
                    writeActivityConfig.setCallFrom(bVy.writeCallFrom);
                    writeActivityConfig.setForumLevel(bVy.forumLevel);
                    writeActivityConfig.setForumAvatar(bVy.avatar);
                    writeActivityConfig.setPrivateThread(bVy.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.maA.dpt()) {
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
        if (this.lYn != null) {
            this.lYn.FT(i);
        }
        this.maA.maK.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.maA != null) {
            this.maA.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.lYn != null) {
            this.lYn.onDestroy();
        }
        super.onDestroy();
    }
}
