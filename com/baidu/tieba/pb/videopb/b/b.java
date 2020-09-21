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
/* loaded from: classes21.dex */
public class b {
    public BaseVideoPBReplyFragment lgc;
    public VideoPbFragment lgd;
    private int kNn = 0;
    boolean kNo = false;
    private final TbRichTextView.i ffu = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.videopb.b.b.1
        /* JADX DEBUG: Multi-variable search result rejected for r6v16, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:30:0x014a A[Catch: Exception -> 0x02e3, TryCatch #0 {Exception -> 0x02e3, blocks: (B:3:0x0003, B:5:0x0045, B:7:0x0072, B:9:0x0084, B:11:0x0090, B:13:0x009a, B:14:0x00a4, B:16:0x00aa, B:18:0x00b0, B:21:0x00c1, B:24:0x00d2, B:25:0x0108, B:28:0x0111, B:30:0x014a, B:32:0x0176, B:33:0x0189, B:35:0x01ca, B:37:0x01d8, B:39:0x01f2, B:40:0x0202, B:42:0x0262, B:44:0x028e, B:45:0x02a1, B:49:0x02ed, B:51:0x02f5, B:53:0x02fd, B:55:0x030d, B:56:0x0326, B:58:0x032e, B:60:0x033c, B:61:0x0341, B:63:0x034b, B:65:0x0355, B:67:0x035f, B:68:0x0363, B:70:0x0369, B:72:0x0373, B:74:0x0389, B:75:0x03a3, B:77:0x03ae, B:78:0x03be, B:80:0x0412, B:82:0x043e, B:83:0x0451), top: B:86:0x0003 }] */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view, String str, int i, boolean z, boolean z2) {
            com.baidu.tieba.pb.videopb.fragment.a dir;
            int i2;
            int i3 = 0;
            try {
                aq aqVar = new aq("c13398");
                aqVar.dF("tid", b.this.lgc.dah().dcf());
                aqVar.dF("fid", b.this.lgc.dah().getForumId());
                aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.ai("obj_locate", 3);
                aqVar.ai("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(aqVar);
                TiebaStatic.eventStat(b.this.lgc.getPageContext().getPageActivity(), "pic_pb", "");
                if (b.this.lgc.dah().getPbData().cZu()) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    if (view.getParent() instanceof TbRichTextView) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                        if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().byH() != null) {
                            ArrayList<TbRichTextImageInfo> byH = tbRichTextView.getRichText().byH();
                            int i4 = 0;
                            i2 = -1;
                            while (i4 < byH.size()) {
                                if (byH.get(i4) != null) {
                                    arrayList.add(byH.get(i4).getSrc());
                                    if (i2 == -1 && str != null && str.equals(byH.get(i4).getSrc())) {
                                        i2 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = byH.get(i4).getSrc();
                                    imageUrlData.originalUrl = byH.get(i4).getSrc();
                                    imageUrlData.isLongPic = byH.get(i4).bzh();
                                    concurrentHashMap.put(byH.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i2 = i2;
                            }
                            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                            aVar.x(arrayList).mX(i2).hF(false).hG(b.this.lgc.dah().dcx()).a(concurrentHashMap).hH(true).hI(false);
                            if (b.this.lgc.dah() != null) {
                                aVar.hJ(b.this.lgc.dah().getHostMode());
                                aVar.zq(b.this.lgc.dah().getFromForumId());
                                if (b.this.lgc.dah().getPbData() != null) {
                                    aVar.s(b.this.lgc.dah().getPbData().cYR());
                                }
                            }
                            ImageViewerConfig dO = aVar.dO(b.this.lgc.getPageContext().getPageActivity());
                            dO.getIntent().putExtra("from", "pb");
                            b.this.lgc.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dO));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                    }
                    i2 = -1;
                    ImageViewerConfig.a aVar2 = new ImageViewerConfig.a();
                    aVar2.x(arrayList).mX(i2).hF(false).hG(b.this.lgc.dah().dcx()).a(concurrentHashMap).hH(true).hI(false);
                    if (b.this.lgc.dah() != null) {
                    }
                    ImageViewerConfig dO2 = aVar2.dO(b.this.lgc.getPageContext().getPageActivity());
                    dO2.getIntent().putExtra("from", "pb");
                    b.this.lgc.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dO2));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                PbActivity.a aVar3 = new PbActivity.a();
                b.this.a(str, i, aVar3);
                if (aVar3.kIq) {
                    TbRichText bv = b.this.bv(str, i);
                    if (bv != null && b.this.kNn >= 0 && b.this.kNn < bv.byG().size()) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        String c = g.c(bv.byG().get(b.this.kNn));
                        while (true) {
                            if (i3 >= aVar3.kIp.size()) {
                                break;
                            } else if (!aVar3.kIp.get(i3).equals(c)) {
                                i3++;
                            } else {
                                aVar3.index = i3;
                                arrayList2.add(c);
                                break;
                            }
                        }
                        if (bv.getPostId() != 0 && (dir = b.this.lgc.dir()) != null) {
                            ArrayList<q> dataList = dir.getDataList();
                            if (y.getCount(dataList) > 0) {
                                Iterator<q> it = dataList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    q next = it.next();
                                    if ((next instanceof PostData) && bv.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                        com.baidu.tieba.pb.c.a.a(b.this.lgc.dah().getPbData(), (PostData) next, ((PostData) next).locate, 8, 3);
                                        break;
                                    }
                                }
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                        if (!y.isEmpty(arrayList2)) {
                            String str2 = arrayList2.get(0);
                            concurrentHashMap2.put(str2, aVar3.dXc.get(str2));
                        }
                        ImageViewerConfig.a aVar4 = new ImageViewerConfig.a();
                        aVar4.x(arrayList2).zl(aVar3.forumName).zm(aVar3.forumId).zn(aVar3.threadId).hF(aVar3.dXa).hH(true).zo(aVar3.lastId).a(concurrentHashMap2).hI(false).hG(b.this.lgc.dah().dcx()).zp(aVar3.postId);
                        if (b.this.lgc.dah() != null) {
                            aVar4.hJ(b.this.lgc.dah().getHostMode());
                            aVar4.zq(b.this.lgc.dah().getFromForumId());
                            if (b.this.lgc.dah().getPbData() != null) {
                                aVar4.s(b.this.lgc.dah().getPbData().cYR());
                            }
                        }
                        ImageViewerConfig dO3 = aVar4.dO(b.this.lgc.getPageContext().getPageActivity());
                        dO3.getIntent().putExtra("from", "pb");
                        b.this.lgc.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dO3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(y.getItem(aVar3.kIp, 0));
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                if (!y.isEmpty(arrayList3)) {
                    String str3 = (String) arrayList3.get(0);
                    concurrentHashMap3.put(str3, aVar3.dXc.get(str3));
                }
                ImageViewerConfig.a aVar5 = new ImageViewerConfig.a();
                aVar5.x(arrayList3).zl(aVar3.forumName).zm(aVar3.forumId).zn(aVar3.threadId).hF(aVar3.dXa).hH(true).zo(aVar3.kIp.get(0)).a(concurrentHashMap3).hG(b.this.lgc.dah().dcx()).hI(false).zp(aVar3.postId).hK(false);
                if (b.this.lgc.dah() != null) {
                    aVar5.hJ(b.this.lgc.dah().getHostMode());
                    aVar5.zq(b.this.lgc.dah().getFromForumId());
                    if (b.this.lgc.dah().getPbData() != null) {
                        aVar5.s(b.this.lgc.dah().getPbData().cYR());
                    }
                }
                ImageViewerConfig dO4 = aVar5.dO(b.this.lgc.getPageContext().getPageActivity());
                dO4.getIntent().putExtra("from", "pb");
                b.this.lgc.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dO4));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    private c eHq = new c(new c.a() { // from class: com.baidu.tieba.pb.videopb.b.b.2
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
            if (b.this.lgd == null || !b.this.lgd.isAdded()) {
                return true;
            }
            if (view != null) {
                if (view.getId() == R.id.richText) {
                    if (b.this.lgd != null && b.this.lgd.cV(view)) {
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
            if (b.this.lgd != null) {
                b.this.lgd.dhG();
            }
            return true;
        }
    });

    public b(BaseVideoPBReplyFragment baseVideoPBReplyFragment) {
        this.lgc = baseVideoPBReplyFragment;
        this.lgd = baseVideoPBReplyFragment.dbL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (this.lgc.checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.lgc.dah() != null && this.lgc.dah().getPbData() != null && postData.dAD() != 1) {
            String dcf = this.lgc.dah().dcf();
            String id = postData.getId();
            int cZg = this.lgc.dah().getPbData() != null ? this.lgc.dah().getPbData().cZg() : 0;
            PbActivity.a NZ = NZ(id);
            if (NZ != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.lgc.getPageContext().getPageActivity()).createSubPbActivityConfig(dcf, id, "pb", true, null, false, null, cZg, postData.dgO(), this.lgc.dah().getPbData().getAnti(), false, postData.bfy() != null ? postData.bfy().getIconInfo() : null).addBigImageData(NZ.kIp, NZ.dXc, NZ.dXa, NZ.index);
                addBigImageData.setKeyPageStartFrom(this.lgc.dah().dcP());
                addBigImageData.setFromFrsForumId(this.lgc.dah().getFromForumId());
                addBigImageData.setKeyFromForumId(this.lgc.dah().getForumId());
                addBigImageData.setBjhData(this.lgc.dah().dco());
                this.lgc.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    public PbActivity.a NZ(String str) {
        String str2;
        if (this.lgc.dah() == null || this.lgc.dah().getPbData() == null || this.lgc.dah().getPbData().cYT() == null || this.lgc.dah().getPbData().cYT().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.lgc.dah().getPbData().cYT().size()) {
                i = 0;
                break;
            } else if (str.equals(this.lgc.dah().getPbData().cYT().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.lgc.dah().getPbData().cYT().get(i);
        if (postData.dAF() == null || postData.dAF().byG() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.dAF().byG().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.byM() != null) {
                    str2 = next.byM().bzc();
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
        if (this.lgc.dah() == null || this.lgc.dah().getPbData() == null || str == null || i < 0) {
            return null;
        }
        f pbData = this.lgc.dah().getPbData();
        if (pbData.cZa() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.cZa());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> cYT = pbData.cYT();
            c(pbData, cYT);
            return c(cYT, str, i);
        }
        return tbRichText;
    }

    private void c(f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.cZf() != null && fVar.cZf().kGS != null && (list = fVar.cZf().kGS) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> byG;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText dAF = arrayList.get(i2).dAF();
            if (dAF != null && (byG = dAF.byG()) != null) {
                int size = byG.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (byG.get(i4) != null && byG.get(i4).getType() == 8) {
                        i3++;
                        if (byG.get(i4).byM().bzc().equals(str) || byG.get(i4).byM().bzd().equals(str)) {
                            int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = byG.get(i4).byM().getWidth() * equipmentDensity;
                            int height = byG.get(i4).byM().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.kNn = i4;
                            return dAF;
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
            f pbData = this.lgc.dah().getPbData();
            TbRichText bv = bv(str, i);
            if (bv != null && (tbRichTextData = bv.byG().get(this.kNn)) != null) {
                aVar.postId = String.valueOf(bv.getPostId());
                aVar.kIp = new ArrayList<>();
                aVar.dXc = new ConcurrentHashMap<>();
                if (!tbRichTextData.byM().bza()) {
                    aVar.kIq = false;
                    String c = g.c(tbRichTextData);
                    aVar.kIp.add(c);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                        imageUrlData.urlType = 38;
                    } else {
                        imageUrlData.urlType = ((e) android.arch.lifecycle.y.b(this.lgc.dbM()).l(e.class)).isFromCDN() ? 17 : 18;
                    }
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                    imageUrlData.isLongPic = g(tbRichTextData);
                    imageUrlData.postId = bv.getPostId();
                    imageUrlData.mIsReserver = this.lgc.dah().dcx();
                    imageUrlData.mIsSeeHost = this.lgc.dah().getHostMode();
                    aVar.dXc.put(c, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.cYR() != null) {
                            aVar.threadId = pbData.cYR().getId();
                        }
                        aVar.dXa = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.kIq = true;
                int size = pbData.cYT().size();
                this.kNo = false;
                aVar.index = -1;
                int a = pbData.cZa() != null ? a(pbData.cZa().dAF(), bv, i, i, aVar.kIp, aVar.dXc) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.cYT().get(i2);
                    if (postData.getId() == null || pbData.cZa() == null || pbData.cZa().getId() == null || !postData.getId().equals(pbData.cZa().getId())) {
                        a = a(postData.dAF(), bv, a, i, aVar.kIp, aVar.dXc);
                    }
                }
                if (aVar.kIp.size() > 0) {
                    aVar.lastId = aVar.kIp.get(aVar.kIp.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.cYR() != null) {
                        aVar.threadId = pbData.cYR().getId();
                    }
                    aVar.dXa = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a;
            }
        }
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo byM;
        String str;
        if (tbRichText == tbRichText2) {
            this.kNo = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.byG().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.byG().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.byM().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.byM().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.byM().bza()) {
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
                            if (tbRichTextData != null && (byM = tbRichTextData.byM()) != null) {
                                String bzc = byM.bzc();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = byM.bzd();
                                } else {
                                    imageUrlData.urlType = ((e) android.arch.lifecycle.y.b(this.lgc.dbM()).l(e.class)).isFromCDN() ? 17 : 18;
                                    str = bzc;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.lgc.dah().dcf(), -1L);
                                imageUrlData.mIsReserver = this.lgc.dah().dcx();
                                imageUrlData.mIsSeeHost = this.lgc.dah().getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c, imageUrlData);
                                }
                            }
                        }
                        if (!this.kNo) {
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
        if (tbRichTextData == null || tbRichTextData.byM() == null) {
            return null;
        }
        return tbRichTextData.byM().bzf();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.byM() == null) {
            return 0L;
        }
        return tbRichTextData.byM().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.byM() == null) {
            return false;
        }
        return tbRichTextData.byM().bzg();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.byM() == null) {
            return false;
        }
        return tbRichTextData.byM().bzh();
    }

    public TbRichTextView.i getOnImageClickListener() {
        return this.ffu;
    }

    public c diq() {
        return this.eHq;
    }
}
