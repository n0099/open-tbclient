package com.baidu.tieba.write.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes3.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private h jVL;
    private i jXV;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.jVL = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cCA() {
                WriteMultiImgsActivity.this.jXV.cDC();
                WriteMultiImgsActivity.this.jXV.su(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cCB() {
                WriteMultiImgsActivity.this.jXV.cDH();
                WriteMultiImgsActivity.this.jXV.su(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean P(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.jXV.R(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cCC() {
                WriteMultiImgsActivity.this.jXV.cCC();
            }
        });
        setContentView(this.jVL.ffS);
        this.jXV = new i(getPageContext(), this.jVL, bundle);
        if (this.jXV.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.jXV.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.jXV != null && this.jXV.jYf != null) {
            bundle.putInt("OutState_Current_Index", this.jXV.jYf.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.jXV.cDF());
            bundle.putSerializable("OutState_Write_Info_Data", this.jXV.bnm());
            this.jXV.jYf.sp(true);
            if (this.jXV.cDI() != null) {
                bundle.putString("OutState_Write_Img_Info", this.jXV.cDI().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cDC() {
        if (this.jXV != null) {
            this.jXV.cDC();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.jXV != null) {
            if (1 == this.jXV.cDF()) {
                ForumWriteData bnm = this.jXV.bnm();
                if (bnm != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, bnm.forumId, bnm.forumName, null, null, 0, bnm.antiData, 13003, false, false, null, false, false, null, null, bnm.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", bnm.mFrom);
                    writeActivityConfig.setCallFrom(bnm.writeCallFrom);
                    writeActivityConfig.setForumLevel(bnm.forumLevel);
                    writeActivityConfig.setForumAvatar(bnm.avatar);
                    writeActivityConfig.setPrivateThread(bnm.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            } else if (2 == this.jXV.cDF()) {
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
                intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, writeImagesInfo.toJsonString());
                if (!v.aa(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
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
        if (this.jVL != null) {
            this.jVL.Du(i);
        }
        this.jXV.jYf.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jXV != null) {
            this.jXV.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.jVL != null) {
            this.jVL.onDestroy();
        }
        super.onDestroy();
    }
}
