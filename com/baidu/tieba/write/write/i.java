package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.h;
/* loaded from: classes3.dex */
public class i {
    private TbPageContext<WriteActivity> etO;
    private WriteImagesInfo mWriteImagesInfo;
    private WriteImageGridView nwi;
    public h nwj;
    private com.baidu.tbadk.img.b fao = new com.baidu.tbadk.img.b();
    private String mFrom = "write";
    private String mForumId = "";
    private h.a nwk = new h.a() { // from class: com.baidu.tieba.write.write.i.1
        @Override // com.baidu.tieba.write.write.h.a
        public void KT(int i) {
            if (i.this.mWriteImagesInfo != null && i.this.mWriteImagesInfo.getChosedFiles() != null && i >= 0 && i < i.this.mWriteImagesInfo.getChosedFiles().size()) {
                ImageFileInfo remove = i.this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.lL().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                i.this.nwj.a(i.this.mWriteImagesInfo);
                i.this.nwj.notifyDataSetChanged();
                if (y.isEmpty(i.this.mWriteImagesInfo.getChosedFiles()) && i.this.etO.getOrignalPage() != 0) {
                    ((WriteActivity) i.this.etO.getOrignalPage()).dAQ();
                }
                if (i.this.etO.getPageActivity() instanceof WriteActivity) {
                    ((WriteActivity) i.this.etO.getPageActivity()).dQv();
                }
            }
        }

        @Override // com.baidu.tieba.write.write.h.a
        public void Ld(int i) {
            int count;
            ImageFileInfo imageInfoAt;
            if (i.this.mWriteImagesInfo != null && (count = y.getCount(i.this.mWriteImagesInfo.getChosedFiles())) != 0 && i >= 0 && i < count && (imageInfoAt = i.this.mWriteImagesInfo.getImageInfoAt(i)) != null && imageInfoAt.getImageType() != 1) {
                i.this.etO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(i.this.etO.getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, i.this.mWriteImagesInfo, i)));
            }
        }

        @Override // com.baidu.tieba.write.write.h.a
        public void dQH() {
            if (i.this.mWriteImagesInfo != null) {
                AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(i.this.etO.getPageActivity(), i.this.mWriteImagesInfo.toJsonString(), true, true);
                albumFloatActivityConfig.getIntent().putExtra("forum_id", i.this.mForumId);
                albumFloatActivityConfig.getIntent().putExtra("from", i.this.mFrom);
                albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                if (i.this.etO.getPageActivity() instanceof WriteActivity) {
                    albumFloatActivityConfig.setCanSelectVideo(((WriteActivity) i.this.etO.getPageActivity()).dNQ());
                    AntiData antiData = new AntiData();
                    antiData.voice_message = ((WriteActivity) i.this.etO.getPageActivity()).fbv;
                    antiData.setIfVoice(((WriteActivity) i.this.etO.getPageActivity()).nuL);
                    albumFloatActivityConfig.setExtraData(antiData, ((WriteActivity) i.this.etO.getPageActivity()).mPrefixData, ((WriteActivity) i.this.etO.getPageActivity()).mtA.getFirstDir(), ((WriteActivity) i.this.etO.getPageActivity()).mtA.getSecondDir());
                }
                albumFloatActivityConfig.setFromWrite(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
            }
        }
    };

    public i(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.etO = tbPageContext;
        this.nwi = (WriteImageGridView) view.findViewById(R.id.write_image_grid_view);
        this.nwj = new h(view.getContext(), this.fao, null, this.nwk);
        this.nwi.setAdapter((ListAdapter) this.nwj);
    }

    public void a(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.mFrom = str;
        this.mForumId = str2;
        this.mWriteImagesInfo = writeImagesInfo;
        this.nwj.a(this.mWriteImagesInfo);
        this.nwj.notifyDataSetChanged();
    }

    public GridView dQI() {
        return this.nwi;
    }

    public void destroy() {
        this.fao.cancelAllAsyncTask();
    }

    public void xW(boolean z) {
        this.nwj.xW(z);
    }
}
