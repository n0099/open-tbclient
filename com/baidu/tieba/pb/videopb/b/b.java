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
/* loaded from: classes16.dex */
public class b {
    public BaseVideoPBReplyFragment kXp;
    public VideoPbFragment kXq;
    private int kEH = 0;
    boolean kEI = false;
    private final TbRichTextView.i fcy = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.videopb.b.b.1
        /* JADX DEBUG: Multi-variable search result rejected for r6v16, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:30:0x014a A[Catch: Exception -> 0x02e3, TryCatch #0 {Exception -> 0x02e3, blocks: (B:3:0x0003, B:5:0x0045, B:7:0x0072, B:9:0x0084, B:11:0x0090, B:13:0x009a, B:14:0x00a4, B:16:0x00aa, B:18:0x00b0, B:21:0x00c1, B:24:0x00d2, B:25:0x0108, B:28:0x0111, B:30:0x014a, B:32:0x0176, B:33:0x0189, B:35:0x01ca, B:37:0x01d8, B:39:0x01f2, B:40:0x0202, B:42:0x0262, B:44:0x028e, B:45:0x02a1, B:49:0x02ed, B:51:0x02f5, B:53:0x02fd, B:55:0x030d, B:56:0x0326, B:58:0x032e, B:60:0x033c, B:61:0x0341, B:63:0x034b, B:65:0x0355, B:67:0x035f, B:68:0x0363, B:70:0x0369, B:72:0x0373, B:74:0x0389, B:75:0x03a3, B:77:0x03ae, B:78:0x03be, B:80:0x0412, B:82:0x043e, B:83:0x0451), top: B:86:0x0003 }] */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view, String str, int i, boolean z, boolean z2) {
            com.baidu.tieba.pb.videopb.fragment.a deM;
            int i2;
            int i3 = 0;
            try {
                aq aqVar = new aq("c13398");
                aqVar.dD("tid", b.this.kXp.cWD().cYB());
                aqVar.dD("fid", b.this.kXp.cWD().getForumId());
                aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.ai("obj_locate", 3);
                aqVar.ai("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(aqVar);
                TiebaStatic.eventStat(b.this.kXp.getPageContext().getPageActivity(), "pic_pb", "");
                if (b.this.kXp.cWD().getPbData().cVO()) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    if (view.getParent() instanceof TbRichTextView) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                        if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bxx() != null) {
                            ArrayList<TbRichTextImageInfo> bxx = tbRichTextView.getRichText().bxx();
                            int i4 = 0;
                            i2 = -1;
                            while (i4 < bxx.size()) {
                                if (bxx.get(i4) != null) {
                                    arrayList.add(bxx.get(i4).getSrc());
                                    if (i2 == -1 && str != null && str.equals(bxx.get(i4).getSrc())) {
                                        i2 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bxx.get(i4).getSrc();
                                    imageUrlData.originalUrl = bxx.get(i4).getSrc();
                                    imageUrlData.isLongPic = bxx.get(i4).bxX();
                                    concurrentHashMap.put(bxx.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i2 = i2;
                            }
                            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                            aVar.x(arrayList).mM(i2).hH(false).hI(b.this.kXp.cWD().cYT()).a(concurrentHashMap).hJ(true).hK(false);
                            if (b.this.kXp.cWD() != null) {
                                aVar.hL(b.this.kXp.cWD().getHostMode());
                                aVar.yU(b.this.kXp.cWD().getFromForumId());
                                if (b.this.kXp.cWD().getPbData() != null) {
                                    aVar.r(b.this.kXp.cWD().getPbData().cVl());
                                }
                            }
                            ImageViewerConfig dP = aVar.dP(b.this.kXp.getPageContext().getPageActivity());
                            dP.getIntent().putExtra("from", "pb");
                            b.this.kXp.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dP));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                    }
                    i2 = -1;
                    ImageViewerConfig.a aVar2 = new ImageViewerConfig.a();
                    aVar2.x(arrayList).mM(i2).hH(false).hI(b.this.kXp.cWD().cYT()).a(concurrentHashMap).hJ(true).hK(false);
                    if (b.this.kXp.cWD() != null) {
                    }
                    ImageViewerConfig dP2 = aVar2.dP(b.this.kXp.getPageContext().getPageActivity());
                    dP2.getIntent().putExtra("from", "pb");
                    b.this.kXp.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dP2));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                PbActivity.a aVar3 = new PbActivity.a();
                b.this.a(str, i, aVar3);
                if (aVar3.kzM) {
                    TbRichText bv = b.this.bv(str, i);
                    if (bv != null && b.this.kEH >= 0 && b.this.kEH < bv.bxw().size()) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        String c = g.c(bv.bxw().get(b.this.kEH));
                        while (true) {
                            if (i3 >= aVar3.kzL.size()) {
                                break;
                            } else if (!aVar3.kzL.get(i3).equals(c)) {
                                i3++;
                            } else {
                                aVar3.index = i3;
                                arrayList2.add(c);
                                break;
                            }
                        }
                        if (bv.getPostId() != 0 && (deM = b.this.kXp.deM()) != null) {
                            ArrayList<q> dataList = deM.getDataList();
                            if (y.getCount(dataList) > 0) {
                                Iterator<q> it = dataList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    q next = it.next();
                                    if ((next instanceof PostData) && bv.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                        com.baidu.tieba.pb.c.a.a(b.this.kXp.cWD().getPbData(), (PostData) next, ((PostData) next).locate, 8, 3);
                                        break;
                                    }
                                }
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                        if (!y.isEmpty(arrayList2)) {
                            String str2 = arrayList2.get(0);
                            concurrentHashMap2.put(str2, aVar3.dUO.get(str2));
                        }
                        ImageViewerConfig.a aVar4 = new ImageViewerConfig.a();
                        aVar4.x(arrayList2).yP(aVar3.forumName).yQ(aVar3.forumId).yR(aVar3.threadId).hH(aVar3.dUM).hJ(true).yS(aVar3.lastId).a(concurrentHashMap2).hK(false).hI(b.this.kXp.cWD().cYT()).yT(aVar3.postId);
                        if (b.this.kXp.cWD() != null) {
                            aVar4.hL(b.this.kXp.cWD().getHostMode());
                            aVar4.yU(b.this.kXp.cWD().getFromForumId());
                            if (b.this.kXp.cWD().getPbData() != null) {
                                aVar4.r(b.this.kXp.cWD().getPbData().cVl());
                            }
                        }
                        ImageViewerConfig dP3 = aVar4.dP(b.this.kXp.getPageContext().getPageActivity());
                        dP3.getIntent().putExtra("from", "pb");
                        b.this.kXp.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dP3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(y.getItem(aVar3.kzL, 0));
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                if (!y.isEmpty(arrayList3)) {
                    String str3 = (String) arrayList3.get(0);
                    concurrentHashMap3.put(str3, aVar3.dUO.get(str3));
                }
                ImageViewerConfig.a aVar5 = new ImageViewerConfig.a();
                aVar5.x(arrayList3).yP(aVar3.forumName).yQ(aVar3.forumId).yR(aVar3.threadId).hH(aVar3.dUM).hJ(true).yS(aVar3.kzL.get(0)).a(concurrentHashMap3).hI(b.this.kXp.cWD().cYT()).hK(false).yT(aVar3.postId).hM(false);
                if (b.this.kXp.cWD() != null) {
                    aVar5.hL(b.this.kXp.cWD().getHostMode());
                    aVar5.yU(b.this.kXp.cWD().getFromForumId());
                    if (b.this.kXp.cWD().getPbData() != null) {
                        aVar5.r(b.this.kXp.cWD().getPbData().cVl());
                    }
                }
                ImageViewerConfig dP4 = aVar5.dP(b.this.kXp.getPageContext().getPageActivity());
                dP4.getIntent().putExtra("from", "pb");
                b.this.kXp.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dP4));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    private c eFf = new c(new c.a() { // from class: com.baidu.tieba.pb.videopb.b.b.2
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
            if (b.this.kXq == null || !b.this.kXq.isAdded()) {
                return true;
            }
            if (view != null) {
                if (view.getId() == R.id.richText) {
                    if (b.this.kXq != null && b.this.kXq.cM(view)) {
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
            if (b.this.kXq != null) {
                b.this.kXq.deb();
            }
            return true;
        }
    });

    public b(BaseVideoPBReplyFragment baseVideoPBReplyFragment) {
        this.kXp = baseVideoPBReplyFragment;
        this.kXq = baseVideoPBReplyFragment.cYh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (this.kXp.checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.kXp.cWD() != null && this.kXp.cWD().getPbData() != null && postData.dwF() != 1) {
            String cYB = this.kXp.cWD().cYB();
            String id = postData.getId();
            int cVA = this.kXp.cWD().getPbData() != null ? this.kXp.cWD().getPbData().cVA() : 0;
            PbActivity.a Nx = Nx(id);
            if (Nx != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.kXp.getPageContext().getPageActivity()).createSubPbActivityConfig(cYB, id, "pb", true, null, false, null, cVA, postData.ddj(), this.kXp.cWD().getPbData().getAnti(), false, postData.beE() != null ? postData.beE().getIconInfo() : null).addBigImageData(Nx.kzL, Nx.dUO, Nx.dUM, Nx.index);
                addBigImageData.setKeyPageStartFrom(this.kXp.cWD().cZl());
                addBigImageData.setFromFrsForumId(this.kXp.cWD().getFromForumId());
                addBigImageData.setKeyFromForumId(this.kXp.cWD().getForumId());
                addBigImageData.setBjhData(this.kXp.cWD().cYK());
                this.kXp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    public PbActivity.a Nx(String str) {
        String str2;
        if (this.kXp.cWD() == null || this.kXp.cWD().getPbData() == null || this.kXp.cWD().getPbData().cVn() == null || this.kXp.cWD().getPbData().cVn().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.kXp.cWD().getPbData().cVn().size()) {
                i = 0;
                break;
            } else if (str.equals(this.kXp.cWD().getPbData().cVn().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.kXp.cWD().getPbData().cVn().get(i);
        if (postData.dwH() == null || postData.dwH().bxw() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.dwH().bxw().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.bxC() != null) {
                    str2 = next.bxC().bxS();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        g.a(postData, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bv(String str, int i) {
        TbRichText tbRichText = null;
        if (this.kXp.cWD() == null || this.kXp.cWD().getPbData() == null || str == null || i < 0) {
            return null;
        }
        f pbData = this.kXp.cWD().getPbData();
        if (pbData.cVu() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.cVu());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> cVn = pbData.cVn();
            c(pbData, cVn);
            return c(cVn, str, i);
        }
        return tbRichText;
    }

    private void c(f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.cVz() != null && fVar.cVz().kyo != null && (list = fVar.cVz().kyo) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> bxw;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText dwH = arrayList.get(i2).dwH();
            if (dwH != null && (bxw = dwH.bxw()) != null) {
                int size = bxw.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (bxw.get(i4) != null && bxw.get(i4).getType() == 8) {
                        i3++;
                        if (bxw.get(i4).bxC().bxS().equals(str) || bxw.get(i4).bxC().bxT().equals(str)) {
                            int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = bxw.get(i4).bxC().getWidth() * equipmentDensity;
                            int height = bxw.get(i4).bxC().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.kEH = i4;
                            return dwH;
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
            f pbData = this.kXp.cWD().getPbData();
            TbRichText bv = bv(str, i);
            if (bv != null && (tbRichTextData = bv.bxw().get(this.kEH)) != null) {
                aVar.postId = String.valueOf(bv.getPostId());
                aVar.kzL = new ArrayList<>();
                aVar.dUO = new ConcurrentHashMap<>();
                if (!tbRichTextData.bxC().bxQ()) {
                    aVar.kzM = false;
                    String c = g.c(tbRichTextData);
                    aVar.kzL.add(c);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                        imageUrlData.urlType = 38;
                    } else {
                        imageUrlData.urlType = ((e) android.arch.lifecycle.y.b(this.kXp.cYi()).l(e.class)).isFromCDN() ? 17 : 18;
                    }
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                    imageUrlData.isLongPic = g(tbRichTextData);
                    imageUrlData.postId = bv.getPostId();
                    imageUrlData.mIsReserver = this.kXp.cWD().cYT();
                    imageUrlData.mIsSeeHost = this.kXp.cWD().getHostMode();
                    aVar.dUO.put(c, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.cVl() != null) {
                            aVar.threadId = pbData.cVl().getId();
                        }
                        aVar.dUM = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.kzM = true;
                int size = pbData.cVn().size();
                this.kEI = false;
                aVar.index = -1;
                int a = pbData.cVu() != null ? a(pbData.cVu().dwH(), bv, i, i, aVar.kzL, aVar.dUO) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.cVn().get(i2);
                    if (postData.getId() == null || pbData.cVu() == null || pbData.cVu().getId() == null || !postData.getId().equals(pbData.cVu().getId())) {
                        a = a(postData.dwH(), bv, a, i, aVar.kzL, aVar.dUO);
                    }
                }
                if (aVar.kzL.size() > 0) {
                    aVar.lastId = aVar.kzL.get(aVar.kzL.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.cVl() != null) {
                        aVar.threadId = pbData.cVl().getId();
                    }
                    aVar.dUM = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a;
            }
        }
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bxC;
        String str;
        if (tbRichText == tbRichText2) {
            this.kEI = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.bxw().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.bxw().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.bxC().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.bxC().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.bxC().bxQ()) {
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
                            if (tbRichTextData != null && (bxC = tbRichTextData.bxC()) != null) {
                                String bxS = bxC.bxS();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = bxC.bxT();
                                } else {
                                    imageUrlData.urlType = ((e) android.arch.lifecycle.y.b(this.kXp.cYi()).l(e.class)).isFromCDN() ? 17 : 18;
                                    str = bxS;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.kXp.cWD().cYB(), -1L);
                                imageUrlData.mIsReserver = this.kXp.cWD().cYT();
                                imageUrlData.mIsSeeHost = this.kXp.cWD().getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c, imageUrlData);
                                }
                            }
                        }
                        if (!this.kEI) {
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
        if (tbRichTextData == null || tbRichTextData.bxC() == null) {
            return null;
        }
        return tbRichTextData.bxC().bxV();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bxC() == null) {
            return 0L;
        }
        return tbRichTextData.bxC().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bxC() == null) {
            return false;
        }
        return tbRichTextData.bxC().bxW();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bxC() == null) {
            return false;
        }
        return tbRichTextData.bxC().bxX();
    }

    public TbRichTextView.i getOnImageClickListener() {
        return this.fcy;
    }

    public c deL() {
        return this.eFf;
    }
}
