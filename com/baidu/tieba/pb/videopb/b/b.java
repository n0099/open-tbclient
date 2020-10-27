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
    public BaseVideoPBReplyFragment lHR;
    public VideoPbFragment lHS;
    private int lpc = 0;
    boolean lpd = false;
    private final TbRichTextView.i fAg = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.videopb.b.b.1
        /* JADX DEBUG: Multi-variable search result rejected for r6v16, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:30:0x014a A[Catch: Exception -> 0x02e3, TryCatch #0 {Exception -> 0x02e3, blocks: (B:3:0x0003, B:5:0x0045, B:7:0x0072, B:9:0x0084, B:11:0x0090, B:13:0x009a, B:14:0x00a4, B:16:0x00aa, B:18:0x00b0, B:21:0x00c1, B:24:0x00d2, B:25:0x0108, B:28:0x0111, B:30:0x014a, B:32:0x0176, B:33:0x0189, B:35:0x01ca, B:37:0x01d8, B:39:0x01f2, B:40:0x0202, B:42:0x0262, B:44:0x028e, B:45:0x02a1, B:49:0x02ed, B:51:0x02f5, B:53:0x02fd, B:55:0x030d, B:56:0x0326, B:58:0x032e, B:60:0x033c, B:61:0x0341, B:63:0x034b, B:65:0x0355, B:67:0x035f, B:68:0x0363, B:70:0x0369, B:72:0x0373, B:74:0x0389, B:75:0x03a3, B:77:0x03ae, B:78:0x03be, B:80:0x0412, B:82:0x043e, B:83:0x0451), top: B:86:0x0003 }] */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view, String str, int i, boolean z, boolean z2) {
            com.baidu.tieba.pb.videopb.fragment.a dpi;
            int i2;
            int i3 = 0;
            try {
                aq aqVar = new aq("c13398");
                aqVar.dR("tid", b.this.lHR.dgX().diV());
                aqVar.dR("fid", b.this.lHR.dgX().getForumId());
                aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.aj("obj_locate", 3);
                aqVar.aj("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(aqVar);
                TiebaStatic.eventStat(b.this.lHR.getPageContext().getPageActivity(), "pic_pb", "");
                if (b.this.lHR.dgX().getPbData().dgl()) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    if (view.getParent() instanceof TbRichTextView) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                        if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bDk() != null) {
                            ArrayList<TbRichTextImageInfo> bDk = tbRichTextView.getRichText().bDk();
                            int i4 = 0;
                            i2 = -1;
                            while (i4 < bDk.size()) {
                                if (bDk.get(i4) != null) {
                                    arrayList.add(bDk.get(i4).getSrc());
                                    if (i2 == -1 && str != null && str.equals(bDk.get(i4).getSrc())) {
                                        i2 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bDk.get(i4).getSrc();
                                    imageUrlData.originalUrl = bDk.get(i4).getSrc();
                                    imageUrlData.isLongPic = bDk.get(i4).bDK();
                                    concurrentHashMap.put(bDk.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i2 = i2;
                            }
                            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                            aVar.x(arrayList).nF(i2).io(false).ip(b.this.lHR.dgX().djn()).a(concurrentHashMap).iq(true).ir(false);
                            if (b.this.lHR.dgX() != null) {
                                aVar.is(b.this.lHR.dgX().getHostMode());
                                aVar.Av(b.this.lHR.dgX().getFromForumId());
                                if (b.this.lHR.dgX().getPbData() != null) {
                                    aVar.s(b.this.lHR.dgX().getPbData().dfI());
                                }
                            }
                            ImageViewerConfig dU = aVar.dU(b.this.lHR.getPageContext().getPageActivity());
                            dU.getIntent().putExtra("from", "pb");
                            b.this.lHR.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                    }
                    i2 = -1;
                    ImageViewerConfig.a aVar2 = new ImageViewerConfig.a();
                    aVar2.x(arrayList).nF(i2).io(false).ip(b.this.lHR.dgX().djn()).a(concurrentHashMap).iq(true).ir(false);
                    if (b.this.lHR.dgX() != null) {
                    }
                    ImageViewerConfig dU2 = aVar2.dU(b.this.lHR.getPageContext().getPageActivity());
                    dU2.getIntent().putExtra("from", "pb");
                    b.this.lHR.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU2));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                PbActivity.a aVar3 = new PbActivity.a();
                b.this.a(str, i, aVar3);
                if (aVar3.lka) {
                    TbRichText bx = b.this.bx(str, i);
                    if (bx != null && b.this.lpc >= 0 && b.this.lpc < bx.bDj().size()) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        String c = g.c(bx.bDj().get(b.this.lpc));
                        while (true) {
                            if (i3 >= aVar3.ljZ.size()) {
                                break;
                            } else if (!aVar3.ljZ.get(i3).equals(c)) {
                                i3++;
                            } else {
                                aVar3.index = i3;
                                arrayList2.add(c);
                                break;
                            }
                        }
                        if (bx.getPostId() != 0 && (dpi = b.this.lHR.dpi()) != null) {
                            ArrayList<q> dataList = dpi.getDataList();
                            if (y.getCount(dataList) > 0) {
                                Iterator<q> it = dataList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    q next = it.next();
                                    if ((next instanceof PostData) && bx.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                        com.baidu.tieba.pb.c.a.a(b.this.lHR.dgX().getPbData(), (PostData) next, ((PostData) next).locate, 8, 3);
                                        break;
                                    }
                                }
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                        if (!y.isEmpty(arrayList2)) {
                            String str2 = arrayList2.get(0);
                            concurrentHashMap2.put(str2, aVar3.erD.get(str2));
                        }
                        ImageViewerConfig.a aVar4 = new ImageViewerConfig.a();
                        aVar4.x(arrayList2).Aq(aVar3.forumName).Ar(aVar3.forumId).As(aVar3.threadId).io(aVar3.erB).iq(true).At(aVar3.lastId).a(concurrentHashMap2).ir(false).ip(b.this.lHR.dgX().djn()).Au(aVar3.postId);
                        if (b.this.lHR.dgX() != null) {
                            aVar4.is(b.this.lHR.dgX().getHostMode());
                            aVar4.Av(b.this.lHR.dgX().getFromForumId());
                            if (b.this.lHR.dgX().getPbData() != null) {
                                aVar4.s(b.this.lHR.dgX().getPbData().dfI());
                            }
                        }
                        ImageViewerConfig dU3 = aVar4.dU(b.this.lHR.getPageContext().getPageActivity());
                        dU3.getIntent().putExtra("from", "pb");
                        b.this.lHR.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(y.getItem(aVar3.ljZ, 0));
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                if (!y.isEmpty(arrayList3)) {
                    String str3 = (String) arrayList3.get(0);
                    concurrentHashMap3.put(str3, aVar3.erD.get(str3));
                }
                ImageViewerConfig.a aVar5 = new ImageViewerConfig.a();
                aVar5.x(arrayList3).Aq(aVar3.forumName).Ar(aVar3.forumId).As(aVar3.threadId).io(aVar3.erB).iq(true).At(aVar3.ljZ.get(0)).a(concurrentHashMap3).ip(b.this.lHR.dgX().djn()).ir(false).Au(aVar3.postId).it(false);
                if (b.this.lHR.dgX() != null) {
                    aVar5.is(b.this.lHR.dgX().getHostMode());
                    aVar5.Av(b.this.lHR.dgX().getFromForumId());
                    if (b.this.lHR.dgX().getPbData() != null) {
                        aVar5.s(b.this.lHR.dgX().getPbData().dfI());
                    }
                }
                ImageViewerConfig dU4 = aVar5.dU(b.this.lHR.getPageContext().getPageActivity());
                dU4.getIntent().putExtra("from", "pb");
                b.this.lHR.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU4));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    private c fbT = new c(new c.a() { // from class: com.baidu.tieba.pb.videopb.b.b.2
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
            if (b.this.lHS == null || !b.this.lHS.isAdded()) {
                return true;
            }
            if (view != null) {
                if (view.getId() == R.id.richText) {
                    if (b.this.lHS != null && b.this.lHS.dd(view)) {
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
            if (b.this.lHS != null) {
                b.this.lHS.dox();
            }
            return true;
        }
    });

    public b(BaseVideoPBReplyFragment baseVideoPBReplyFragment) {
        this.lHR = baseVideoPBReplyFragment;
        this.lHS = baseVideoPBReplyFragment.diB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (this.lHR.checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.lHR.dgX() != null && this.lHR.dgX().getPbData() != null && postData.dHx() != 1) {
            String diV = this.lHR.dgX().diV();
            String id = postData.getId();
            int dfX = this.lHR.dgX().getPbData() != null ? this.lHR.dgX().getPbData().dfX() : 0;
            PbActivity.a Pm = Pm(id);
            if (Pm != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.lHR.getPageContext().getPageActivity()).createSubPbActivityConfig(diV, id, "pb", true, null, false, null, dfX, postData.dnF(), this.lHR.dgX().getPbData().getAnti(), false, postData.bka() != null ? postData.bka().getIconInfo() : null).addBigImageData(Pm.ljZ, Pm.erD, Pm.erB, Pm.index);
                addBigImageData.setKeyPageStartFrom(this.lHR.dgX().djF());
                addBigImageData.setFromFrsForumId(this.lHR.dgX().getFromForumId());
                addBigImageData.setKeyFromForumId(this.lHR.dgX().getForumId());
                addBigImageData.setBjhData(this.lHR.dgX().dje());
                this.lHR.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    public PbActivity.a Pm(String str) {
        String str2;
        if (this.lHR.dgX() == null || this.lHR.dgX().getPbData() == null || this.lHR.dgX().getPbData().dfK() == null || this.lHR.dgX().getPbData().dfK().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.lHR.dgX().getPbData().dfK().size()) {
                i = 0;
                break;
            } else if (str.equals(this.lHR.dgX().getPbData().dfK().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.lHR.dgX().getPbData().dfK().get(i);
        if (postData.dHz() == null || postData.dHz().bDj() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.dHz().bDj().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.bDp() != null) {
                    str2 = next.bDp().bDF();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        g.a(postData, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bx(String str, int i) {
        TbRichText tbRichText = null;
        if (this.lHR.dgX() == null || this.lHR.dgX().getPbData() == null || str == null || i < 0) {
            return null;
        }
        f pbData = this.lHR.dgX().getPbData();
        if (pbData.dfR() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.dfR());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> dfK = pbData.dfK();
            c(pbData, dfK);
            return c(dfK, str, i);
        }
        return tbRichText;
    }

    private void c(f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.dfW() != null && fVar.dfW().liC != null && (list = fVar.dfW().liC) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> bDj;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText dHz = arrayList.get(i2).dHz();
            if (dHz != null && (bDj = dHz.bDj()) != null) {
                int size = bDj.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (bDj.get(i4) != null && bDj.get(i4).getType() == 8) {
                        i3++;
                        if (bDj.get(i4).bDp().bDF().equals(str) || bDj.get(i4).bDp().bDG().equals(str)) {
                            int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = bDj.get(i4).bDp().getWidth() * equipmentDensity;
                            int height = bDj.get(i4).bDp().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.lpc = i4;
                            return dHz;
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
            f pbData = this.lHR.dgX().getPbData();
            TbRichText bx = bx(str, i);
            if (bx != null && (tbRichTextData = bx.bDj().get(this.lpc)) != null) {
                aVar.postId = String.valueOf(bx.getPostId());
                aVar.ljZ = new ArrayList<>();
                aVar.erD = new ConcurrentHashMap<>();
                if (!tbRichTextData.bDp().bDD()) {
                    aVar.lka = false;
                    String c = g.c(tbRichTextData);
                    aVar.ljZ.add(c);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                        imageUrlData.urlType = 38;
                    } else {
                        imageUrlData.urlType = ((e) android.arch.lifecycle.y.b(this.lHR.diC()).l(e.class)).isFromCDN() ? 17 : 18;
                    }
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                    imageUrlData.isLongPic = g(tbRichTextData);
                    imageUrlData.postId = bx.getPostId();
                    imageUrlData.mIsReserver = this.lHR.dgX().djn();
                    imageUrlData.mIsSeeHost = this.lHR.dgX().getHostMode();
                    aVar.erD.put(c, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.dfI() != null) {
                            aVar.threadId = pbData.dfI().getId();
                        }
                        aVar.erB = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.lka = true;
                int size = pbData.dfK().size();
                this.lpd = false;
                aVar.index = -1;
                int a2 = pbData.dfR() != null ? a(pbData.dfR().dHz(), bx, i, i, aVar.ljZ, aVar.erD) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.dfK().get(i2);
                    if (postData.getId() == null || pbData.dfR() == null || pbData.dfR().getId() == null || !postData.getId().equals(pbData.dfR().getId())) {
                        a2 = a(postData.dHz(), bx, a2, i, aVar.ljZ, aVar.erD);
                    }
                }
                if (aVar.ljZ.size() > 0) {
                    aVar.lastId = aVar.ljZ.get(aVar.ljZ.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.dfI() != null) {
                        aVar.threadId = pbData.dfI().getId();
                    }
                    aVar.erB = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bDp;
        String str;
        if (tbRichText == tbRichText2) {
            this.lpd = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.bDj().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.bDj().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.bDp().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.bDp().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.bDp().bDD()) {
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
                            if (tbRichTextData != null && (bDp = tbRichTextData.bDp()) != null) {
                                String bDF = bDp.bDF();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = bDp.bDG();
                                } else {
                                    imageUrlData.urlType = ((e) android.arch.lifecycle.y.b(this.lHR.diC()).l(e.class)).isFromCDN() ? 17 : 18;
                                    str = bDF;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.lHR.dgX().diV(), -1L);
                                imageUrlData.mIsReserver = this.lHR.dgX().djn();
                                imageUrlData.mIsSeeHost = this.lHR.dgX().getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c, imageUrlData);
                                }
                            }
                        }
                        if (!this.lpd) {
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
        if (tbRichTextData == null || tbRichTextData.bDp() == null) {
            return null;
        }
        return tbRichTextData.bDp().bDI();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bDp() == null) {
            return 0L;
        }
        return tbRichTextData.bDp().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bDp() == null) {
            return false;
        }
        return tbRichTextData.bDp().bDJ();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bDp() == null) {
            return false;
        }
        return tbRichTextData.bDp().bDK();
    }

    public TbRichTextView.i getOnImageClickListener() {
        return this.fAg;
    }

    public c dph() {
        return this.fbT;
    }
}
