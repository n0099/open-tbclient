package com.baidu.tieba.pb.videopb.b;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import androidx.lifecycle.ViewModelProviders;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.g;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class b {
    public BaseVideoPBReplyFragment mhu;
    public VideoPbFragment mhv;
    private int lOs = 0;
    boolean lOt = false;
    private final TbRichTextView.i fWO = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.videopb.b.b.1
        /* JADX DEBUG: Multi-variable search result rejected for r6v15, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0149 A[Catch: Exception -> 0x02e2, TryCatch #0 {Exception -> 0x02e2, blocks: (B:3:0x0003, B:5:0x0045, B:7:0x0072, B:9:0x0084, B:11:0x0090, B:13:0x009a, B:14:0x00a3, B:16:0x00a9, B:18:0x00af, B:21:0x00c0, B:24:0x00d1, B:25:0x0107, B:28:0x0110, B:30:0x0149, B:32:0x0175, B:33:0x0188, B:35:0x01c9, B:37:0x01d7, B:39:0x01f1, B:40:0x0201, B:42:0x0261, B:44:0x028d, B:45:0x02a0, B:49:0x02ec, B:51:0x02f4, B:53:0x02fc, B:55:0x030c, B:56:0x0326, B:58:0x032e, B:60:0x033c, B:61:0x0341, B:63:0x034b, B:65:0x0355, B:67:0x035f, B:68:0x0363, B:70:0x0369, B:72:0x0373, B:74:0x0389, B:75:0x03a3, B:77:0x03ae, B:78:0x03be, B:80:0x0412, B:82:0x043e, B:83:0x0451), top: B:86:0x0003 }] */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view, String str, int i, boolean z, boolean z2) {
            com.baidu.tieba.pb.videopb.fragment.a dwu;
            int i2;
            int i3 = 0;
            try {
                aq aqVar = new aq("c13398");
                aqVar.dX("tid", b.this.mhu.dnW().dpX());
                aqVar.dX("fid", b.this.mhu.dnW().getForumId());
                aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.an("obj_locate", 3);
                aqVar.an("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(aqVar);
                TiebaStatic.eventStat(b.this.mhu.getPageContext().getPageActivity(), "pic_pb", "");
                if (b.this.mhu.dnW().getPbData().dni()) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    if (view.getParent() instanceof TbRichTextView) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                        if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bKY() != null) {
                            ArrayList<TbRichTextImageInfo> bKY = tbRichTextView.getRichText().bKY();
                            i2 = -1;
                            while (i3 < bKY.size()) {
                                if (bKY.get(i3) != null) {
                                    arrayList.add(bKY.get(i3).getSrc());
                                    if (i2 == -1 && str != null && str.equals(bKY.get(i3).getSrc())) {
                                        i2 = i3;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bKY.get(i3).getSrc();
                                    imageUrlData.originalUrl = bKY.get(i3).getSrc();
                                    imageUrlData.isLongPic = bKY.get(i3).bLv();
                                    concurrentHashMap.put(bKY.get(i3).getSrc(), imageUrlData);
                                }
                                i3++;
                                i2 = i2;
                            }
                            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                            aVar.x(arrayList).ot(i2).ji(false).jj(b.this.mhu.dnW().dqq()).d(concurrentHashMap).jk(true).jl(false);
                            if (b.this.mhu.dnW() != null) {
                                aVar.jm(b.this.mhu.dnW().getHostMode());
                                aVar.AI(b.this.mhu.dnW().getFromForumId());
                                if (b.this.mhu.dnW().getPbData() != null) {
                                    aVar.s(b.this.mhu.dnW().getPbData().dmF());
                                }
                            }
                            ImageViewerConfig eS = aVar.eS(b.this.mhu.getPageContext().getPageActivity());
                            eS.getIntent().putExtra("from", "pb");
                            b.this.mhu.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eS));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                    }
                    i2 = -1;
                    ImageViewerConfig.a aVar2 = new ImageViewerConfig.a();
                    aVar2.x(arrayList).ot(i2).ji(false).jj(b.this.mhu.dnW().dqq()).d(concurrentHashMap).jk(true).jl(false);
                    if (b.this.mhu.dnW() != null) {
                    }
                    ImageViewerConfig eS2 = aVar2.eS(b.this.mhu.getPageContext().getPageActivity());
                    eS2.getIntent().putExtra("from", "pb");
                    b.this.mhu.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eS2));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                PbActivity.a aVar3 = new PbActivity.a();
                b.this.a(str, i, aVar3);
                if (aVar3.lJl) {
                    TbRichText bG = b.this.bG(str, i);
                    if (bG != null && b.this.lOs >= 0 && b.this.lOs < bG.bKX().size()) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        String c = g.c(bG.bKX().get(b.this.lOs));
                        int i4 = 0;
                        while (true) {
                            if (i4 >= aVar3.lJk.size()) {
                                break;
                            } else if (!aVar3.lJk.get(i4).equals(c)) {
                                i4++;
                            } else {
                                aVar3.index = i4;
                                arrayList2.add(c);
                                break;
                            }
                        }
                        if (bG.getPostId() != 0 && (dwu = b.this.mhu.dwu()) != null) {
                            ArrayList<n> dataList = dwu.getDataList();
                            if (x.getCount(dataList) > 0) {
                                Iterator<n> it = dataList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    n next = it.next();
                                    if ((next instanceof PostData) && bG.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                        com.baidu.tieba.pb.c.a.a(b.this.mhu.dnW().getPbData(), (PostData) next, ((PostData) next).locate, 8, 3);
                                        break;
                                    }
                                }
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                        if (!x.isEmpty(arrayList2)) {
                            String str2 = arrayList2.get(0);
                            concurrentHashMap2.put(str2, aVar3.eMr.get(str2));
                        }
                        ImageViewerConfig.a aVar4 = new ImageViewerConfig.a();
                        aVar4.x(arrayList2).AD(aVar3.forumName).AE(aVar3.forumId).AF(aVar3.threadId).ji(aVar3.eMp).jk(true).AG(aVar3.lastId).d(concurrentHashMap2).jl(false).jj(b.this.mhu.dnW().dqq()).AH(aVar3.postId);
                        if (b.this.mhu.dnW() != null) {
                            aVar4.jm(b.this.mhu.dnW().getHostMode());
                            aVar4.AI(b.this.mhu.dnW().getFromForumId());
                            if (b.this.mhu.dnW().getPbData() != null) {
                                aVar4.s(b.this.mhu.dnW().getPbData().dmF());
                            }
                        }
                        ImageViewerConfig eS3 = aVar4.eS(b.this.mhu.getPageContext().getPageActivity());
                        eS3.getIntent().putExtra("from", "pb");
                        b.this.mhu.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eS3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(x.getItem(aVar3.lJk, 0));
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                if (!x.isEmpty(arrayList3)) {
                    String str3 = (String) arrayList3.get(0);
                    concurrentHashMap3.put(str3, aVar3.eMr.get(str3));
                }
                ImageViewerConfig.a aVar5 = new ImageViewerConfig.a();
                aVar5.x(arrayList3).AD(aVar3.forumName).AE(aVar3.forumId).AF(aVar3.threadId).ji(aVar3.eMp).jk(true).AG(aVar3.lJk.get(0)).d(concurrentHashMap3).jj(b.this.mhu.dnW().dqq()).jl(false).AH(aVar3.postId).jn(false);
                if (b.this.mhu.dnW() != null) {
                    aVar5.jm(b.this.mhu.dnW().getHostMode());
                    aVar5.AI(b.this.mhu.dnW().getFromForumId());
                    if (b.this.mhu.dnW().getPbData() != null) {
                        aVar5.s(b.this.mhu.dnW().getPbData().dmF());
                    }
                }
                ImageViewerConfig eS4 = aVar5.eS(b.this.mhu.getPageContext().getPageActivity());
                eS4.getIntent().putExtra("from", "pb");
                b.this.mhu.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eS4));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    private c fyb = new c(new c.a() { // from class: com.baidu.tieba.pb.videopb.b.b.2
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTapEvent(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onSingleTapConfirmed(View view, MotionEvent motionEvent) {
            if (b.this.mhv == null || !b.this.mhv.isAdded()) {
                return true;
            }
            if (view != null) {
                if (view.getId() == R.id.richText) {
                    if (b.this.mhv != null && b.this.mhv.dE(view)) {
                        return true;
                    }
                } else if (view.getId() == R.id.pb_floor_item_layout) {
                    if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                        b.this.g((SparseArray) view.getTag(R.id.tag_from));
                    }
                } else if ((view instanceof TbRichTextView) || view.getId() == R.id.pb_post_header_layout) {
                    SparseArray sparseArray = null;
                    if (view.getTag() instanceof SparseArray) {
                        sparseArray = (SparseArray) view.getTag();
                    }
                    if (sparseArray != null) {
                        b.this.g(sparseArray);
                    } else {
                        return false;
                    }
                }
            }
            if (b.this.mhv != null) {
                b.this.mhv.dvJ();
            }
            return true;
        }
    });

    public b(BaseVideoPBReplyFragment baseVideoPBReplyFragment) {
        this.mhu = baseVideoPBReplyFragment;
        this.mhv = baseVideoPBReplyFragment.dpD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(SparseArray<Object> sparseArray) {
        PostData postData;
        if (this.mhu.checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.mhu.dnW() != null && this.mhu.dnW().getPbData() != null && postData.dPe() != 1) {
            String dpX = this.mhu.dnW().dpX();
            String id = postData.getId();
            int dmU = this.mhu.dnW().getPbData() != null ? this.mhu.dnW().getPbData().dmU() : 0;
            PbActivity.a PM = PM(id);
            if (PM != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.mhu.getPageContext().getPageActivity()).createSubPbActivityConfig(dpX, id, "pb", true, null, false, null, dmU, postData.duP(), this.mhu.dnW().getPbData().getAnti(), false, postData.brr() != null ? postData.brr().getIconInfo() : null).addBigImageData(PM.lJk, PM.eMr, PM.eMp, PM.index);
                addBigImageData.setKeyPageStartFrom(this.mhu.dnW().dqI());
                addBigImageData.setFromFrsForumId(this.mhu.dnW().getFromForumId());
                addBigImageData.setKeyFromForumId(this.mhu.dnW().getForumId());
                addBigImageData.setBjhData(this.mhu.dnW().dqh());
                this.mhu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    public PbActivity.a PM(String str) {
        String str2;
        if (this.mhu.dnW() == null || this.mhu.dnW().getPbData() == null || this.mhu.dnW().getPbData().dmH() == null || this.mhu.dnW().getPbData().dmH().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.mhu.dnW().getPbData().dmH().size()) {
                i = 0;
                break;
            } else if (str.equals(this.mhu.dnW().getPbData().dmH().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.mhu.dnW().getPbData().dmH().get(i);
        if (postData.dPg() == null || postData.dPg().bKX() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.dPg().bKX().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.bLd() != null) {
                    str2 = next.bLd().bLq();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        g.a(postData, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bG(String str, int i) {
        TbRichText tbRichText = null;
        if (this.mhu.dnW() == null || this.mhu.dnW().getPbData() == null || str == null || i < 0) {
            return null;
        }
        f pbData = this.mhu.dnW().getPbData();
        if (pbData.dmO() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.dmO());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> dmH = pbData.dmH();
            c(pbData, dmH);
            return c(dmH, str, i);
        }
        return tbRichText;
    }

    private void c(f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.dmT() != null && fVar.dmT().lHx != null && (list = fVar.dmT().lHx) != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (list.size() > 0 && arrayList.size() > 0) {
                arrayList3.addAll(list);
                Iterator<PostData> it = arrayList.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null) {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            PostData postData = (PostData) it2.next();
                            if (postData != null && !TextUtils.isEmpty(next.getId()) && !TextUtils.isEmpty(postData.getId()) && next.getId().equals(postData.getId())) {
                                arrayList2.add(postData);
                            }
                        }
                    }
                }
                if (arrayList2.size() > 0) {
                    arrayList3.removeAll(arrayList2);
                }
                if (arrayList3.size() > 0) {
                    arrayList.addAll(arrayList3);
                }
            }
        }
    }

    private TbRichText c(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> bKX;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText dPg = arrayList.get(i2).dPg();
            if (dPg != null && (bKX = dPg.bKX()) != null) {
                int size = bKX.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (bKX.get(i4) != null && bKX.get(i4).getType() == 8) {
                        i3++;
                        if (bKX.get(i4).bLd().bLq().equals(str) || bKX.get(i4).bLd().bLr().equals(str)) {
                            int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = bKX.get(i4).bLd().getWidth() * equipmentDensity;
                            int height = bKX.get(i4).bLd().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.lOs = i4;
                            return dPg;
                        } else if (i3 <= i) {
                        }
                    }
                    i4++;
                    i3 = i3;
                }
                continue;
            }
        }
        return null;
    }

    public void a(String str, int i, PbActivity.a aVar) {
        TbRichTextData tbRichTextData;
        if (aVar != null) {
            f pbData = this.mhu.dnW().getPbData();
            TbRichText bG = bG(str, i);
            if (bG != null && (tbRichTextData = bG.bKX().get(this.lOs)) != null) {
                aVar.postId = String.valueOf(bG.getPostId());
                aVar.lJk = new ArrayList<>();
                aVar.eMr = new ConcurrentHashMap<>();
                if (!tbRichTextData.bLd().bLo()) {
                    aVar.lJl = false;
                    String c = g.c(tbRichTextData);
                    aVar.lJk.add(c);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                        imageUrlData.urlType = 38;
                    } else {
                        imageUrlData.urlType = ((VideoPbViewModel) ViewModelProviders.of(this.mhu.dpE()).get(VideoPbViewModel.class)).isFromCDN() ? 17 : 18;
                    }
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                    imageUrlData.isLongPic = g(tbRichTextData);
                    imageUrlData.postId = bG.getPostId();
                    imageUrlData.mIsReserver = this.mhu.dnW().dqq();
                    imageUrlData.mIsSeeHost = this.mhu.dnW().getHostMode();
                    aVar.eMr.put(c, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.dmF() != null) {
                            aVar.threadId = pbData.dmF().getId();
                        }
                        aVar.eMp = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.lJl = true;
                int size = pbData.dmH().size();
                this.lOt = false;
                aVar.index = -1;
                int a2 = pbData.dmO() != null ? a(pbData.dmO().dPg(), bG, i, i, aVar.lJk, aVar.eMr) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.dmH().get(i2);
                    if (postData.getId() == null || pbData.dmO() == null || pbData.dmO().getId() == null || !postData.getId().equals(pbData.dmO().getId())) {
                        a2 = a(postData.dPg(), bG, a2, i, aVar.lJk, aVar.eMr);
                    }
                }
                if (aVar.lJk.size() > 0) {
                    aVar.lastId = aVar.lJk.get(aVar.lJk.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.dmF() != null) {
                        aVar.threadId = pbData.dmF().getId();
                    }
                    aVar.eMp = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bLd;
        String str;
        if (tbRichText == tbRichText2) {
            this.lOt = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.bKX().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.bKX().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.bLd().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.bLd().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.bLd().bLo()) {
                        if (tbRichText == tbRichText2 && i8 <= i2) {
                            i3 = i8;
                            i4 = i7 - 1;
                        }
                        i3 = i8;
                        i4 = i7;
                    } else if (tbRichTextData.getType() == 20) {
                        i3 = i8;
                        i4 = i7;
                    } else {
                        String c = g.c(tbRichTextData);
                        if (!TextUtils.isEmpty(c)) {
                            arrayList.add(c);
                            if (tbRichTextData != null && (bLd = tbRichTextData.bLd()) != null) {
                                String bLq = bLd.bLq();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = bLd.bLr();
                                } else {
                                    imageUrlData.urlType = ((VideoPbViewModel) ViewModelProviders.of(this.mhu.dpE()).get(VideoPbViewModel.class)).isFromCDN() ? 17 : 18;
                                    str = bLq;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.mhu.dnW().dpX(), -1L);
                                imageUrlData.mIsReserver = this.mhu.dnW().dqq();
                                imageUrlData.mIsSeeHost = this.mhu.dnW().getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c, imageUrlData);
                                }
                            }
                        }
                        if (!this.lOt) {
                            i3 = i8;
                            i4 = i7 + 1;
                        }
                        i3 = i8;
                        i4 = i7;
                    }
                }
                i6++;
                i5 = i3;
                i7 = i4;
            }
            return i7;
        }
        return i;
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bLd() == null) {
            return null;
        }
        return tbRichTextData.bLd().bLt();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bLd() == null) {
            return 0L;
        }
        return tbRichTextData.bLd().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bLd() == null) {
            return false;
        }
        return tbRichTextData.bLd().bLu();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bLd() == null) {
            return false;
        }
        return tbRichTextData.bLd().bLv();
    }

    public TbRichTextView.i getOnImageClickListener() {
        return this.fWO;
    }

    public c dwt() {
        return this.fyb;
    }
}
