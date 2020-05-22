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
    private h lXc;
    private i lZm;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.lXc = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dnY() {
                WriteMultiImgsActivity.this.lZm.dpc();
                WriteMultiImgsActivity.this.lZm.vD(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dnZ() {
                WriteMultiImgsActivity.this.lZm.dph();
                WriteMultiImgsActivity.this.lZm.vD(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean S(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.lZm.U(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void doa() {
                WriteMultiImgsActivity.this.lZm.doa();
            }
        });
        setContentView(this.lXc.hay);
        this.lZm = new i(getPageContext(), this.lXc, bundle);
        if (this.lZm.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.lZm.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.lZm != null && this.lZm.lZw != null) {
            bundle.putInt("OutState_Current_Index", this.lZm.lZw.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.lZm.dpf());
            bundle.putSerializable("OutState_Write_Info_Data", this.lZm.bVw());
            this.lZm.lZw.vy(true);
            if (this.lZm.dpi() != null) {
                bundle.putString("OutState_Write_Img_Info", this.lZm.dpi().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dpc() {
        if (this.lZm != null) {
            this.lZm.dpc();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.lZm != null) {
            if (1 == this.lZm.dpf()) {
                ForumWriteData bVw = this.lZm.bVw();
                if (bVw != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, bVw.forumId, bVw.forumName, null, null, 0, bVw.antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, bVw.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", bVw.mFrom);
                    writeActivityConfig.setCallFrom(bVw.writeCallFrom);
                    writeActivityConfig.setForumLevel(bVw.forumLevel);
                    writeActivityConfig.setForumAvatar(bVw.avatar);
                    writeActivityConfig.setPrivateThread(bVw.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.lZm.dpf()) {
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
        if (this.lXc != null) {
            this.lXc.FR(i);
        }
        this.lZm.lZw.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.lZm != null) {
            this.lZm.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.lXc != null) {
            this.lXc.onDestroy();
        }
        super.onDestroy();
    }
}
