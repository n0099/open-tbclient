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
    private h jsm;
    private i juw;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.jsm = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cqp() {
                WriteMultiImgsActivity.this.juw.crp();
                WriteMultiImgsActivity.this.juw.rl(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cqq() {
                WriteMultiImgsActivity.this.juw.cru();
                WriteMultiImgsActivity.this.juw.rl(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean O(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.juw.Q(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cqr() {
                WriteMultiImgsActivity.this.juw.cqr();
            }
        });
        setContentView(this.jsm.eIH);
        this.juw = new i(getPageContext(), this.jsm, bundle);
        if (this.juw.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.juw.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.juw != null && this.juw.juG != null) {
            bundle.putInt("OutState_Current_Index", this.juw.juG.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.juw.crs());
            bundle.putSerializable("OutState_Write_Info_Data", this.juw.bcU());
            this.juw.juG.rg(true);
            if (this.juw.crv() != null) {
                bundle.putString("OutState_Write_Img_Info", this.juw.crv().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void crp() {
        if (this.juw != null) {
            this.juw.crp();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.juw != null) {
            if (1 == this.juw.crs()) {
                ForumWriteData bcU = this.juw.bcU();
                if (bcU != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, bcU.forumId, bcU.forumName, null, null, 0, bcU.antiData, 13003, false, false, null, false, false, null, null, bcU.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", bcU.mFrom);
                    writeActivityConfig.setCallFrom(bcU.writeCallFrom);
                    writeActivityConfig.setForumLevel(bcU.forumLevel);
                    writeActivityConfig.setForumAvatar(bcU.avatar);
                    writeActivityConfig.setPrivateThread(bcU.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            } else if (2 == this.juw.crs()) {
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
                if (!v.T(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
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
        if (this.jsm != null) {
            this.jsm.BC(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.juw != null) {
            this.juw.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.jsm != null) {
            this.jsm.onDestroy();
        }
        super.onDestroy();
    }
}
