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
    private h hWX;
    private i hZg;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hWX = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bOU() {
                WriteMultiImgsActivity.this.hZg.bPV();
                WriteMultiImgsActivity.this.hZg.oH(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bOV() {
                WriteMultiImgsActivity.this.hZg.bQa();
                WriteMultiImgsActivity.this.hZg.oH(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean G(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.hZg.I(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bOW() {
                WriteMultiImgsActivity.this.hZg.bOW();
            }
        });
        setContentView(this.hWX.drW);
        this.hZg = new i(getPageContext(), this.hWX, bundle);
        if (this.hZg.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.hZg.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.hZg != null && this.hZg.hZq != null) {
            bundle.putInt("OutState_Current_Index", this.hZg.hZq.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.hZg.bPY());
            bundle.putSerializable("OutState_Write_Info_Data", this.hZg.aBc());
            this.hZg.hZq.oC(true);
            if (this.hZg.bQb() != null) {
                bundle.putString("OutState_Write_Img_Info", this.hZg.bQb().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bPV() {
        if (this.hZg != null) {
            this.hZg.bPV();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.hZg != null) {
            if (1 == this.hZg.bPY()) {
                ForumWriteData aBc = this.hZg.aBc();
                if (aBc != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, aBc.forumId, aBc.forumName, null, null, 0, aBc.antiData, 13003, false, false, null, false, false, null, null, aBc.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", aBc.mFrom);
                    writeActivityConfig.setCallFrom(aBc.writeCallFrom);
                    writeActivityConfig.setForumLevel(aBc.forumLevel);
                    writeActivityConfig.setForumAvatar(aBc.avatar);
                    writeActivityConfig.setPrivateThread(aBc.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            } else if (2 == this.hZg.bPY()) {
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
                if (!v.I(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
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
        if (this.hWX != null) {
            this.hWX.xx(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hZg != null) {
            this.hZg.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.hWX != null) {
            this.hWX.onDestroy();
        }
        super.onDestroy();
    }
}
