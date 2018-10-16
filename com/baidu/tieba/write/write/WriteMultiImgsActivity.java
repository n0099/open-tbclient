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
    private h hOc;
    private i hQl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hOc = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bNp() {
                WriteMultiImgsActivity.this.hQl.bOq();
                WriteMultiImgsActivity.this.hQl.or(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bNq() {
                WriteMultiImgsActivity.this.hQl.bOv();
                WriteMultiImgsActivity.this.hQl.or(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean G(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.hQl.I(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bNr() {
                WriteMultiImgsActivity.this.hQl.bNr();
            }
        });
        setContentView(this.hOc.dkp);
        this.hQl = new i(getPageContext(), this.hOc, bundle);
        if (this.hQl.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.hQl.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.hQl != null && this.hQl.hQv != null) {
            bundle.putInt("OutState_Current_Index", this.hQl.hQv.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.hQl.bOt());
            bundle.putSerializable("OutState_Write_Info_Data", this.hQl.azU());
            this.hQl.hQv.om(true);
            if (this.hQl.bOw() != null) {
                bundle.putString("OutState_Write_Img_Info", this.hQl.bOw().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bOq() {
        if (this.hQl != null) {
            this.hQl.bOq();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.hQl != null) {
            if (1 == this.hQl.bOt()) {
                ForumWriteData azU = this.hQl.azU();
                if (azU != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, azU.forumId, azU.forumName, null, null, 0, azU.antiData, 13003, false, false, null, false, false, null, null, azU.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", azU.mFrom);
                    writeActivityConfig.setCallFrom(azU.writeCallFrom);
                    writeActivityConfig.setForumLevel(azU.forumLevel);
                    writeActivityConfig.setForumAvatar(azU.avatar);
                    writeActivityConfig.setPrivateThread(azU.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            } else if (2 == this.hQl.bOt()) {
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
                if (!v.J(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
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
        if (this.hOc != null) {
            this.hOc.wH(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hQl != null) {
            this.hQl.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.hOc != null) {
            this.hOc.onDestroy();
        }
        super.onDestroy();
    }
}
