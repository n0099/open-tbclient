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
    private h hGQ;
    private i hIZ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hGQ = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bKd() {
                WriteMultiImgsActivity.this.hIZ.bLf();
                WriteMultiImgsActivity.this.hIZ.ob(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bKe() {
                WriteMultiImgsActivity.this.hIZ.bLk();
                WriteMultiImgsActivity.this.hIZ.ob(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean G(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.hIZ.I(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bKf() {
                WriteMultiImgsActivity.this.hIZ.bKf();
            }
        });
        setContentView(this.hGQ.dcf);
        this.hIZ = new i(getPageContext(), this.hGQ, bundle);
        if (this.hIZ.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.hIZ.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.hIZ != null && this.hIZ.hJj != null) {
            bundle.putInt("OutState_Current_Index", this.hIZ.hJj.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.hIZ.bLi());
            bundle.putSerializable("OutState_Write_Info_Data", this.hIZ.awy());
            this.hIZ.hJj.nW(true);
            if (this.hIZ.bLl() != null) {
                bundle.putString("OutState_Write_Img_Info", this.hIZ.bLl().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bLf() {
        if (this.hIZ != null) {
            this.hIZ.bLf();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.hIZ != null) {
            if (1 == this.hIZ.bLi()) {
                ForumWriteData awy = this.hIZ.awy();
                if (awy != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, awy.forumId, awy.forumName, null, null, 0, awy.antiData, 13003, false, false, null, false, false, null, null, awy.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", awy.mFrom);
                    writeActivityConfig.setCallFrom(awy.writeCallFrom);
                    writeActivityConfig.setForumLevel(awy.forumLevel);
                    writeActivityConfig.setForumAvatar(awy.avatar);
                    writeActivityConfig.setPrivateThread(awy.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            } else if (2 == this.hIZ.bLi()) {
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
                if (!v.z(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
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
        if (this.hGQ != null) {
            this.hGQ.wk(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hIZ != null) {
            this.hIZ.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.hGQ != null) {
            this.hGQ.onDestroy();
        }
        super.onDestroy();
    }
}
