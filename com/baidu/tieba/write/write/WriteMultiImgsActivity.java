package com.baidu.tieba.write.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
import com.google.protobuf.CodedInputStream;
import d.b.j0.v3.v.j;
import d.b.j0.v3.v.k;
import d.b.j0.v3.v.n.b.c;
/* loaded from: classes5.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    public static final String OUTSTATE_KEY_CURRENT_INDEX = "OutState_Current_Index";
    public static final String OUTSTATE_KEY_WRITE_ENTRANCE = "OutState_Write_Entrance";
    public static final String OUTSTATE_KEY_WRITE_IMG_INFO = "OutState_Write_Img_Info";
    public static final String OUTSTATE_KEY_WRITE_INFO_DATA = "OutState_Write_Info_Data";
    public k mControler;
    public j mMainView;

    /* loaded from: classes5.dex */
    public class a implements c {
        public a() {
        }

        @Override // d.b.j0.v3.v.n.b.c
        public void a() {
            WriteMultiImgsActivity.this.mControler.s();
            WriteMultiImgsActivity.this.mControler.r(false);
        }

        @Override // d.b.j0.v3.v.n.b.c
        public boolean b(Bitmap bitmap) {
            return WriteMultiImgsActivity.this.mControler.q(bitmap);
        }

        @Override // d.b.j0.v3.v.n.b.c
        public void c() {
            WriteMultiImgsActivity.this.mControler.A();
        }

        @Override // d.b.j0.v3.v.n.b.c
        public void d() {
            WriteMultiImgsActivity.this.mControler.n();
            WriteMultiImgsActivity.this.mControler.r(true);
        }
    }

    public void addAction() {
        k kVar = this.mControler;
        if (kVar != null) {
            kVar.n();
        }
    }

    public void delAction() {
        k kVar = this.mControler;
        if (kVar != null) {
            kVar.s();
        }
    }

    public void finishActivity(boolean z, WriteImagesInfo writeImagesInfo) {
        k kVar = this.mControler;
        if (kVar != null) {
            if (1 == kVar.u()) {
                ForumWriteData v = this.mControler.v();
                if (v != null) {
                    if (WriteActivityConfig.isAsyncWriting()) {
                        return;
                    }
                    WriteActivityConfig.newInstance(this).setType(10).setForumWriteData(v).setWriteImagesInfo(writeImagesInfo).send();
                }
            } else if (2 == this.mControler.u()) {
                Intent intent = new Intent(this, WriteActivity.class);
                intent.putExtra("KEY_WRITE_IMAGES_INFO_STRING", writeImagesInfo.toJsonString());
                intent.setFlags(536870912);
                intent.setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                startActivity(intent);
                finish();
                return;
            }
        }
        if (!z) {
            setResult(0);
        } else if (writeImagesInfo == null) {
            return;
        } else {
            Intent intent2 = new Intent();
            intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, writeImagesInfo.toJsonString());
            if (!ListUtils.isEmpty(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
                intent2.putExtra("file_name", writeImagesInfo.getChosedFiles().get(0).extra);
            }
            setResult(-1, intent2);
        }
        finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        setResult(0);
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        j jVar = this.mMainView;
        if (jVar != null) {
            jVar.h(i);
        }
        this.mControler.f63983c.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        j jVar = new j(getPageContext(), new a());
        this.mMainView = jVar;
        setContentView(jVar.k);
        k kVar = new k(getPageContext(), this.mMainView, bundle);
        this.mControler = kVar;
        if (kVar.j != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.mControler.j);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        k kVar = this.mControler;
        if (kVar != null) {
            kVar.t();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        j jVar = this.mMainView;
        if (jVar != null) {
            jVar.o();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        MultiImagePagerAdapter multiImagePagerAdapter;
        k kVar = this.mControler;
        if (kVar != null && (multiImagePagerAdapter = kVar.f63983c) != null) {
            bundle.putInt(OUTSTATE_KEY_CURRENT_INDEX, multiImagePagerAdapter.k());
            bundle.putInt(OUTSTATE_KEY_WRITE_ENTRANCE, this.mControler.u());
            bundle.putSerializable(OUTSTATE_KEY_WRITE_INFO_DATA, this.mControler.v());
            this.mControler.f63983c.g(true);
            if (this.mControler.w() != null) {
                bundle.putString(OUTSTATE_KEY_WRITE_IMG_INFO, this.mControler.w().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }
}
