package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class au implements View.OnLongClickListener {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        boolean z;
        gg ggVar;
        c.b bVar;
        PbModel pbModel;
        com.baidu.adp.widget.a.a aVar3;
        String str;
        gg ggVar2;
        c.b bVar2;
        com.baidu.adp.widget.a.a aVar4;
        if (view instanceof TbImageView) {
            this.ewh.evq = ((TbImageView) view).getBdImage();
            this.ewh.evr = ((TbImageView) view).getUrl();
            aVar3 = this.ewh.evq;
            if (aVar3 != null) {
                str = this.ewh.evr;
                if (!TextUtils.isEmpty(str)) {
                    if (view.getTag(w.h.tag_rich_text_meme_info) == null || !(view.getTag(w.h.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.ewh.evs = null;
                    } else {
                        this.ewh.evs = (TbRichTextMemeInfo) view.getTag(w.h.tag_rich_text_meme_info);
                    }
                    ggVar2 = this.ewh.euU;
                    bVar2 = this.ewh.evY;
                    aVar4 = this.ewh.evq;
                    ggVar2.a(bVar2, aVar4.isGif());
                }
            }
        } else {
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray != null) {
                this.ewh.evW = (PostData) sparseArray.get(w.h.tag_clip_board);
                if (this.ewh.evW != null) {
                    aVar = this.ewh.dPW;
                    if (aVar != null) {
                        aVar2 = this.ewh.dPW;
                        if (aVar2.nz() && this.ewh.evW.getId() != null) {
                            String id = this.ewh.evW.getId();
                            pbModel = this.ewh.eue;
                            if (id.equals(pbModel.rA())) {
                                z = true;
                                boolean booleanValue = ((Boolean) sparseArray.get(w.h.tag_is_subpb)).booleanValue();
                                ggVar = this.ewh.euU;
                                bVar = this.ewh.evX;
                                ggVar.a(bVar, z, booleanValue);
                            }
                        }
                        z = false;
                        boolean booleanValue2 = ((Boolean) sparseArray.get(w.h.tag_is_subpb)).booleanValue();
                        ggVar = this.ewh.euU;
                        bVar = this.ewh.evX;
                        ggVar.a(bVar, z, booleanValue2);
                    }
                }
            }
        }
        return true;
    }
}
