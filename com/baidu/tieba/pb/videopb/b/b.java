package com.baidu.tieba.pb.videopb.b;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
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
import com.baidu.tieba.pb.videopb.e;
import com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes22.dex */
public class b {
    public BaseVideoPBReplyFragment lNN;
    public VideoPbFragment lNO;
    private int luZ = 0;
    boolean lva = false;
    private final TbRichTextView.i fFW = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.videopb.b.b.1
        /* JADX DEBUG: Multi-variable search result rejected for r6v16, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:30:0x014a A[Catch: Exception -> 0x02e3, TryCatch #0 {Exception -> 0x02e3, blocks: (B:3:0x0003, B:5:0x0045, B:7:0x0072, B:9:0x0084, B:11:0x0090, B:13:0x009a, B:14:0x00a4, B:16:0x00aa, B:18:0x00b0, B:21:0x00c1, B:24:0x00d2, B:25:0x0108, B:28:0x0111, B:30:0x014a, B:32:0x0176, B:33:0x0189, B:35:0x01ca, B:37:0x01d8, B:39:0x01f2, B:40:0x0202, B:42:0x0262, B:44:0x028e, B:45:0x02a1, B:49:0x02ed, B:51:0x02f5, B:53:0x02fd, B:55:0x030d, B:56:0x0326, B:58:0x032e, B:60:0x033c, B:61:0x0341, B:63:0x034b, B:65:0x0355, B:67:0x035f, B:68:0x0363, B:70:0x0369, B:72:0x0373, B:74:0x0389, B:75:0x03a3, B:77:0x03ae, B:78:0x03be, B:80:0x0412, B:82:0x043e, B:83:0x0451), top: B:86:0x0003 }] */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view, String str, int i, boolean z, boolean z2) {
            com.baidu.tieba.pb.videopb.fragment.a drK;
            int i2;
            int i3 = 0;
            try {
                aq aqVar = new aq("c13398");
                aqVar.dR("tid", b.this.lNN.djz().dlx());
                aqVar.dR("fid", b.this.lNN.djz().getForumId());
                aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.al("obj_locate", 3);
                aqVar.al("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(aqVar);
                TiebaStatic.eventStat(b.this.lNN.getPageContext().getPageActivity(), "pic_pb", "");
                if (b.this.lNN.djz().getPbData().diN()) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    if (view.getParent() instanceof TbRichTextView) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                        if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bFJ() != null) {
                            ArrayList<TbRichTextImageInfo> bFJ = tbRichTextView.getRichText().bFJ();
                            int i4 = 0;
                            i2 = -1;
                            while (i4 < bFJ.size()) {
                                if (bFJ.get(i4) != null) {
                                    arrayList.add(bFJ.get(i4).getSrc());
                                    if (i2 == -1 && str != null && str.equals(bFJ.get(i4).getSrc())) {
                                        i2 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bFJ.get(i4).getSrc();
                                    imageUrlData.originalUrl = bFJ.get(i4).getSrc();
                                    imageUrlData.isLongPic = bFJ.get(i4).bGj();
                                    concurrentHashMap.put(bFJ.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i2 = i2;
                            }
                            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                            aVar.x(arrayList).nP(i2).ix(false).iy(b.this.lNN.djz().dlP()).a(concurrentHashMap).iz(true).iA(false);
                            if (b.this.lNN.djz() != null) {
                                aVar.iB(b.this.lNN.djz().getHostMode());
                                aVar.AJ(b.this.lNN.djz().getFromForumId());
                                if (b.this.lNN.djz().getPbData() != null) {
                                    aVar.s(b.this.lNN.djz().getPbData().dik());
                                }
                            }
                            ImageViewerConfig dU = aVar.dU(b.this.lNN.getPageContext().getPageActivity());
                            dU.getIntent().putExtra("from", "pb");
                            b.this.lNN.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                    }
                    i2 = -1;
                    ImageViewerConfig.a aVar2 = new ImageViewerConfig.a();
                    aVar2.x(arrayList).nP(i2).ix(false).iy(b.this.lNN.djz().dlP()).a(concurrentHashMap).iz(true).iA(false);
                    if (b.this.lNN.djz() != null) {
                    }
                    ImageViewerConfig dU2 = aVar2.dU(b.this.lNN.getPageContext().getPageActivity());
                    dU2.getIntent().putExtra("from", "pb");
                    b.this.lNN.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU2));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                PbActivity.a aVar3 = new PbActivity.a();
                b.this.a(str, i, aVar3);
                if (aVar3.lqb) {
                    TbRichText bz = b.this.bz(str, i);
                    if (bz != null && b.this.luZ >= 0 && b.this.luZ < bz.bFI().size()) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        String c = g.c(bz.bFI().get(b.this.luZ));
                        while (true) {
                            if (i3 >= aVar3.lqa.size()) {
                                break;
                            } else if (!aVar3.lqa.get(i3).equals(c)) {
                                i3++;
                            } else {
                                aVar3.index = i3;
                                arrayList2.add(c);
                                break;
                            }
                        }
                        if (bz.getPostId() != 0 && (drK = b.this.lNN.drK()) != null) {
                            ArrayList<q> dataList = drK.getDataList();
                            if (y.getCount(dataList) > 0) {
                                Iterator<q> it = dataList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    q next = it.next();
                                    if ((next instanceof PostData) && bz.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                        com.baidu.tieba.pb.c.a.a(b.this.lNN.djz().getPbData(), (PostData) next, ((PostData) next).locate, 8, 3);
                                        break;
                                    }
                                }
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                        if (!y.isEmpty(arrayList2)) {
                            String str2 = arrayList2.get(0);
                            concurrentHashMap2.put(str2, aVar3.exw.get(str2));
                        }
                        ImageViewerConfig.a aVar4 = new ImageViewerConfig.a();
                        aVar4.x(arrayList2).AE(aVar3.forumName).AF(aVar3.forumId).AG(aVar3.threadId).ix(aVar3.exu).iz(true).AH(aVar3.lastId).a(concurrentHashMap2).iA(false).iy(b.this.lNN.djz().dlP()).AI(aVar3.postId);
                        if (b.this.lNN.djz() != null) {
                            aVar4.iB(b.this.lNN.djz().getHostMode());
                            aVar4.AJ(b.this.lNN.djz().getFromForumId());
                            if (b.this.lNN.djz().getPbData() != null) {
                                aVar4.s(b.this.lNN.djz().getPbData().dik());
                            }
                        }
                        ImageViewerConfig dU3 = aVar4.dU(b.this.lNN.getPageContext().getPageActivity());
                        dU3.getIntent().putExtra("from", "pb");
                        b.this.lNN.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(y.getItem(aVar3.lqa, 0));
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                if (!y.isEmpty(arrayList3)) {
                    String str3 = (String) arrayList3.get(0);
                    concurrentHashMap3.put(str3, aVar3.exw.get(str3));
                }
                ImageViewerConfig.a aVar5 = new ImageViewerConfig.a();
                aVar5.x(arrayList3).AE(aVar3.forumName).AF(aVar3.forumId).AG(aVar3.threadId).ix(aVar3.exu).iz(true).AH(aVar3.lqa.get(0)).a(concurrentHashMap3).iy(b.this.lNN.djz().dlP()).iA(false).AI(aVar3.postId).iC(false);
                if (b.this.lNN.djz() != null) {
                    aVar5.iB(b.this.lNN.djz().getHostMode());
                    aVar5.AJ(b.this.lNN.djz().getFromForumId());
                    if (b.this.lNN.djz().getPbData() != null) {
                        aVar5.s(b.this.lNN.djz().getPbData().dik());
                    }
                }
                ImageViewerConfig dU4 = aVar5.dU(b.this.lNN.getPageContext().getPageActivity());
                dU4.getIntent().putExtra("from", "pb");
                b.this.lNN.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU4));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    private c fhK = new c(new c.a() { // from class: com.baidu.tieba.pb.videopb.b.b.2
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
            if (b.this.lNO == null || !b.this.lNO.isAdded()) {
                return true;
            }
            if (view != null) {
                if (view.getId() == R.id.richText) {
                    if (b.this.lNO != null && b.this.lNO.di(view)) {
                        return true;
                    }
                } else if (view.getId() == R.id.pb_floor_item_layout) {
                    if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                        b.this.d((SparseArray) view.getTag(R.id.tag_from));
                    }
                } else if ((view instanceof TbRichTextView) || view.getId() == R.id.pb_post_header_layout) {
                    SparseArray sparseArray = null;
                    if (view.getTag() instanceof SparseArray) {
                        sparseArray = (SparseArray) view.getTag();
                    }
                    if (sparseArray != null) {
                        b.this.d(sparseArray);
                    } else {
                        return false;
                    }
                }
            }
            if (b.this.lNO != null) {
                b.this.lNO.dqZ();
            }
            return true;
        }
    });

    public b(BaseVideoPBReplyFragment baseVideoPBReplyFragment) {
        this.lNN = baseVideoPBReplyFragment;
        this.lNO = baseVideoPBReplyFragment.dld();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (this.lNN.checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.lNN.djz() != null && this.lNN.djz().getPbData() != null && postData.dJZ() != 1) {
            String dlx = this.lNN.djz().dlx();
            String id = postData.getId();
            int diz = this.lNN.djz().getPbData() != null ? this.lNN.djz().getPbData().diz() : 0;
            PbActivity.a PD = PD(id);
            if (PD != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.lNN.getPageContext().getPageActivity()).createSubPbActivityConfig(dlx, id, "pb", true, null, false, null, diz, postData.dqh(), this.lNN.djz().getPbData().getAnti(), false, postData.bmA() != null ? postData.bmA().getIconInfo() : null).addBigImageData(PD.lqa, PD.exw, PD.exu, PD.index);
                addBigImageData.setKeyPageStartFrom(this.lNN.djz().dmh());
                addBigImageData.setFromFrsForumId(this.lNN.djz().getFromForumId());
                addBigImageData.setKeyFromForumId(this.lNN.djz().getForumId());
                addBigImageData.setBjhData(this.lNN.djz().dlG());
                this.lNN.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    public PbActivity.a PD(String str) {
        String str2;
        if (this.lNN.djz() == null || this.lNN.djz().getPbData() == null || this.lNN.djz().getPbData().dim() == null || this.lNN.djz().getPbData().dim().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.lNN.djz().getPbData().dim().size()) {
                i = 0;
                break;
            } else if (str.equals(this.lNN.djz().getPbData().dim().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.lNN.djz().getPbData().dim().get(i);
        if (postData.dKb() == null || postData.dKb().bFI() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.dKb().bFI().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.bFO() != null) {
                    str2 = next.bFO().bGe();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        g.a(postData, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bz(String str, int i) {
        TbRichText tbRichText = null;
        if (this.lNN.djz() == null || this.lNN.djz().getPbData() == null || str == null || i < 0) {
            return null;
        }
        f pbData = this.lNN.djz().getPbData();
        if (pbData.dit() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.dit());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> dim = pbData.dim();
            c(pbData, dim);
            return c(dim, str, i);
        }
        return tbRichText;
    }

    private void c(f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.diy() != null && fVar.diy().loD != null && (list = fVar.diy().loD) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> bFI;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText dKb = arrayList.get(i2).dKb();
            if (dKb != null && (bFI = dKb.bFI()) != null) {
                int size = bFI.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (bFI.get(i4) != null && bFI.get(i4).getType() == 8) {
                        i3++;
                        if (bFI.get(i4).bFO().bGe().equals(str) || bFI.get(i4).bFO().bGf().equals(str)) {
                            int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = bFI.get(i4).bFO().getWidth() * equipmentDensity;
                            int height = bFI.get(i4).bFO().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.luZ = i4;
                            return dKb;
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
            f pbData = this.lNN.djz().getPbData();
            TbRichText bz = bz(str, i);
            if (bz != null && (tbRichTextData = bz.bFI().get(this.luZ)) != null) {
                aVar.postId = String.valueOf(bz.getPostId());
                aVar.lqa = new ArrayList<>();
                aVar.exw = new ConcurrentHashMap<>();
                if (!tbRichTextData.bFO().bGc()) {
                    aVar.lqb = false;
                    String c = g.c(tbRichTextData);
                    aVar.lqa.add(c);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                        imageUrlData.urlType = 38;
                    } else {
                        imageUrlData.urlType = ((e) android.arch.lifecycle.y.b(this.lNN.dle()).l(e.class)).isFromCDN() ? 17 : 18;
                    }
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                    imageUrlData.isLongPic = g(tbRichTextData);
                    imageUrlData.postId = bz.getPostId();
                    imageUrlData.mIsReserver = this.lNN.djz().dlP();
                    imageUrlData.mIsSeeHost = this.lNN.djz().getHostMode();
                    aVar.exw.put(c, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.dik() != null) {
                            aVar.threadId = pbData.dik().getId();
                        }
                        aVar.exu = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.lqb = true;
                int size = pbData.dim().size();
                this.lva = false;
                aVar.index = -1;
                int a2 = pbData.dit() != null ? a(pbData.dit().dKb(), bz, i, i, aVar.lqa, aVar.exw) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.dim().get(i2);
                    if (postData.getId() == null || pbData.dit() == null || pbData.dit().getId() == null || !postData.getId().equals(pbData.dit().getId())) {
                        a2 = a(postData.dKb(), bz, a2, i, aVar.lqa, aVar.exw);
                    }
                }
                if (aVar.lqa.size() > 0) {
                    aVar.lastId = aVar.lqa.get(aVar.lqa.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.dik() != null) {
                        aVar.threadId = pbData.dik().getId();
                    }
                    aVar.exu = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bFO;
        String str;
        if (tbRichText == tbRichText2) {
            this.lva = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.bFI().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.bFI().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.bFO().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.bFO().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.bFO().bGc()) {
                        if (tbRichText == tbRichText2 && i8 <= i2) {
                            i4 = i7 - 1;
                            i3 = i8;
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
                            if (tbRichTextData != null && (bFO = tbRichTextData.bFO()) != null) {
                                String bGe = bFO.bGe();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = bFO.bGf();
                                } else {
                                    imageUrlData.urlType = ((e) android.arch.lifecycle.y.b(this.lNN.dle()).l(e.class)).isFromCDN() ? 17 : 18;
                                    str = bGe;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.lNN.djz().dlx(), -1L);
                                imageUrlData.mIsReserver = this.lNN.djz().dlP();
                                imageUrlData.mIsSeeHost = this.lNN.djz().getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c, imageUrlData);
                                }
                            }
                        }
                        if (!this.lva) {
                            i4 = i7 + 1;
                            i3 = i8;
                        }
                        i3 = i8;
                        i4 = i7;
                    }
                }
                i6++;
                i7 = i4;
                i5 = i3;
            }
            return i7;
        }
        return i;
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bFO() == null) {
            return null;
        }
        return tbRichTextData.bFO().bGh();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bFO() == null) {
            return 0L;
        }
        return tbRichTextData.bFO().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bFO() == null) {
            return false;
        }
        return tbRichTextData.bFO().bGi();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bFO() == null) {
            return false;
        }
        return tbRichTextData.bFO().bGj();
    }

    public TbRichTextView.i getOnImageClickListener() {
        return this.fFW;
    }

    public c drJ() {
        return this.fhK;
    }
}
