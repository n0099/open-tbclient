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
import com.baidu.tbadk.core.util.ar;
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
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class b {
    public BaseVideoPBReplyFragment moi;
    public VideoPbFragment moj;
    private int lVc = 0;
    boolean lVd = false;
    private final TbRichTextView.i fVW = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.videopb.b.b.1
        /* JADX DEBUG: Multi-variable search result rejected for r6v15, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0149 A[Catch: Exception -> 0x02e2, TryCatch #0 {Exception -> 0x02e2, blocks: (B:3:0x0003, B:5:0x0045, B:7:0x0072, B:9:0x0084, B:11:0x0090, B:13:0x009a, B:14:0x00a3, B:16:0x00a9, B:18:0x00af, B:21:0x00c0, B:24:0x00d1, B:25:0x0107, B:28:0x0110, B:30:0x0149, B:32:0x0175, B:33:0x0188, B:35:0x01c9, B:37:0x01d7, B:39:0x01f1, B:40:0x0201, B:42:0x0261, B:44:0x028d, B:45:0x02a0, B:49:0x02ec, B:51:0x02f4, B:53:0x02fc, B:55:0x030c, B:56:0x0326, B:58:0x032e, B:60:0x033c, B:61:0x0341, B:63:0x034b, B:65:0x0355, B:67:0x035f, B:68:0x0363, B:70:0x0369, B:72:0x0373, B:74:0x0389, B:75:0x03a3, B:77:0x03ae, B:78:0x03be, B:80:0x0412, B:82:0x043e, B:83:0x0451), top: B:86:0x0003 }] */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view, String str, int i, boolean z, boolean z2) {
            com.baidu.tieba.pb.videopb.fragment.a dvf;
            int i2;
            int i3 = 0;
            try {
                ar arVar = new ar("c13398");
                arVar.dR("tid", b.this.moi.dmG().doJ());
                arVar.dR("fid", b.this.moi.dmG().getForumId());
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                arVar.aq("obj_locate", 3);
                arVar.aq("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(arVar);
                TiebaStatic.eventStat(b.this.moi.getPageContext().getPageActivity(), "pic_pb", "");
                if (b.this.moi.dmG().getPbData().dlS()) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    if (view.getParent() instanceof TbRichTextView) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                        if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bHE() != null) {
                            ArrayList<TbRichTextImageInfo> bHE = tbRichTextView.getRichText().bHE();
                            i2 = -1;
                            while (i3 < bHE.size()) {
                                if (bHE.get(i3) != null) {
                                    arrayList.add(bHE.get(i3).getSrc());
                                    if (i2 == -1 && str != null && str.equals(bHE.get(i3).getSrc())) {
                                        i2 = i3;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bHE.get(i3).getSrc();
                                    imageUrlData.originalUrl = bHE.get(i3).getSrc();
                                    imageUrlData.isLongPic = bHE.get(i3).bIb();
                                    concurrentHashMap.put(bHE.get(i3).getSrc(), imageUrlData);
                                }
                                i3++;
                                i2 = i2;
                            }
                            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                            aVar.s(arrayList).mR(i2).jg(false).jh(b.this.moi.dmG().dpc()).d(concurrentHashMap).ji(true).jj(false);
                            if (b.this.moi.dmG() != null) {
                                aVar.jk(b.this.moi.dmG().getHostMode());
                                aVar.zV(b.this.moi.dmG().getFromForumId());
                                if (b.this.moi.dmG().getPbData() != null) {
                                    aVar.s(b.this.moi.dmG().getPbData().dlp());
                                }
                            }
                            ImageViewerConfig eO = aVar.eO(b.this.moi.getPageContext().getPageActivity());
                            eO.getIntent().putExtra("from", "pb");
                            b.this.moi.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eO));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                    }
                    i2 = -1;
                    ImageViewerConfig.a aVar2 = new ImageViewerConfig.a();
                    aVar2.s(arrayList).mR(i2).jg(false).jh(b.this.moi.dmG().dpc()).d(concurrentHashMap).ji(true).jj(false);
                    if (b.this.moi.dmG() != null) {
                    }
                    ImageViewerConfig eO2 = aVar2.eO(b.this.moi.getPageContext().getPageActivity());
                    eO2.getIntent().putExtra("from", "pb");
                    b.this.moi.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eO2));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                PbActivity.a aVar3 = new PbActivity.a();
                b.this.a(str, i, aVar3);
                if (aVar3.lPN) {
                    TbRichText bH = b.this.bH(str, i);
                    if (bH != null && b.this.lVc >= 0 && b.this.lVc < bH.bHD().size()) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        String c = g.c(bH.bHD().get(b.this.lVc));
                        int i4 = 0;
                        while (true) {
                            if (i4 >= aVar3.lPM.size()) {
                                break;
                            } else if (!aVar3.lPM.get(i4).equals(c)) {
                                i4++;
                            } else {
                                aVar3.index = i4;
                                arrayList2.add(c);
                                break;
                            }
                        }
                        if (bH.getPostId() != 0 && (dvf = b.this.moi.dvf()) != null) {
                            ArrayList<n> dataList = dvf.getDataList();
                            if (y.getCount(dataList) > 0) {
                                Iterator<n> it = dataList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    n next = it.next();
                                    if ((next instanceof PostData) && bH.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                        com.baidu.tieba.pb.c.a.a(b.this.moi.dmG().getPbData(), (PostData) next, ((PostData) next).locate, 8, 3);
                                        break;
                                    }
                                }
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                        if (!y.isEmpty(arrayList2)) {
                            String str2 = arrayList2.get(0);
                            concurrentHashMap2.put(str2, aVar3.eLn.get(str2));
                        }
                        ImageViewerConfig.a aVar4 = new ImageViewerConfig.a();
                        aVar4.s(arrayList2).zQ(aVar3.forumName).zR(aVar3.forumId).zS(aVar3.threadId).jg(aVar3.eLl).ji(true).zT(aVar3.lastId).d(concurrentHashMap2).jj(false).jh(b.this.moi.dmG().dpc()).zU(aVar3.postId);
                        if (b.this.moi.dmG() != null) {
                            aVar4.jk(b.this.moi.dmG().getHostMode());
                            aVar4.zV(b.this.moi.dmG().getFromForumId());
                            if (b.this.moi.dmG().getPbData() != null) {
                                aVar4.s(b.this.moi.dmG().getPbData().dlp());
                            }
                        }
                        ImageViewerConfig eO3 = aVar4.eO(b.this.moi.getPageContext().getPageActivity());
                        eO3.getIntent().putExtra("from", "pb");
                        b.this.moi.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eO3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(y.getItem(aVar3.lPM, 0));
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                if (!y.isEmpty(arrayList3)) {
                    String str3 = (String) arrayList3.get(0);
                    concurrentHashMap3.put(str3, aVar3.eLn.get(str3));
                }
                ImageViewerConfig.a aVar5 = new ImageViewerConfig.a();
                aVar5.s(arrayList3).zQ(aVar3.forumName).zR(aVar3.forumId).zS(aVar3.threadId).jg(aVar3.eLl).ji(true).zT(aVar3.lPM.get(0)).d(concurrentHashMap3).jh(b.this.moi.dmG().dpc()).jj(false).zU(aVar3.postId).jl(false);
                if (b.this.moi.dmG() != null) {
                    aVar5.jk(b.this.moi.dmG().getHostMode());
                    aVar5.zV(b.this.moi.dmG().getFromForumId());
                    if (b.this.moi.dmG().getPbData() != null) {
                        aVar5.s(b.this.moi.dmG().getPbData().dlp());
                    }
                }
                ImageViewerConfig eO4 = aVar5.eO(b.this.moi.getPageContext().getPageActivity());
                eO4.getIntent().putExtra("from", "pb");
                b.this.moi.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eO4));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    private c fxj = new c(new c.a() { // from class: com.baidu.tieba.pb.videopb.b.b.2
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
            if (b.this.moj == null || !b.this.moj.isAdded()) {
                return true;
            }
            if (view != null) {
                if (view.getId() == R.id.richText) {
                    if (b.this.moj != null && b.this.moj.dC(view)) {
                        return true;
                    }
                } else if (view.getId() == R.id.pb_floor_item_layout) {
                    if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                        b.this.e((SparseArray) view.getTag(R.id.tag_from));
                    }
                } else if ((view instanceof TbRichTextView) || view.getId() == R.id.pb_post_header_layout) {
                    SparseArray sparseArray = null;
                    if (view.getTag() instanceof SparseArray) {
                        sparseArray = (SparseArray) view.getTag();
                    }
                    if (sparseArray != null) {
                        b.this.e(sparseArray);
                    } else {
                        return false;
                    }
                }
            }
            if (b.this.moj != null) {
                b.this.moj.duu();
            }
            return true;
        }
    });

    public b(BaseVideoPBReplyFragment baseVideoPBReplyFragment) {
        this.moi = baseVideoPBReplyFragment;
        this.moj = baseVideoPBReplyFragment.dop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(SparseArray<Object> sparseArray) {
        PostData postData;
        if (this.moi.checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.moi.dmG() != null && this.moi.dmG().getPbData() != null && postData.dNO() != 1) {
            String doJ = this.moi.dmG().doJ();
            String id = postData.getId();
            int dlE = this.moi.dmG().getPbData() != null ? this.moi.dmG().getPbData().dlE() : 0;
            PbActivity.a PD = PD(id);
            if (PD != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.moi.getPageContext().getPageActivity()).createSubPbActivityConfig(doJ, id, "pb", true, null, false, null, dlE, postData.dtB(), this.moi.dmG().getPbData().getAnti(), false, postData.bnS() != null ? postData.bnS().getIconInfo() : null).addBigImageData(PD.lPM, PD.eLn, PD.eLl, PD.index);
                addBigImageData.setKeyPageStartFrom(this.moi.dmG().dpu());
                addBigImageData.setFromFrsForumId(this.moi.dmG().getFromForumId());
                addBigImageData.setKeyFromForumId(this.moi.dmG().getForumId());
                addBigImageData.setBjhData(this.moi.dmG().doT());
                this.moi.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    public PbActivity.a PD(String str) {
        String str2;
        if (this.moi.dmG() == null || this.moi.dmG().getPbData() == null || this.moi.dmG().getPbData().dlr() == null || this.moi.dmG().getPbData().dlr().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.moi.dmG().getPbData().dlr().size()) {
                i = 0;
                break;
            } else if (str.equals(this.moi.dmG().getPbData().dlr().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.moi.dmG().getPbData().dlr().get(i);
        if (postData.dNQ() == null || postData.dNQ().bHD() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.dNQ().bHD().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.bHJ() != null) {
                    str2 = next.bHJ().bHW();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        g.a(postData, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bH(String str, int i) {
        TbRichText tbRichText = null;
        if (this.moi.dmG() == null || this.moi.dmG().getPbData() == null || str == null || i < 0) {
            return null;
        }
        f pbData = this.moi.dmG().getPbData();
        if (pbData.dly() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.dly());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> dlr = pbData.dlr();
            c(pbData, dlr);
            return c(dlr, str, i);
        }
        return tbRichText;
    }

    private void c(f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.dlD() != null && fVar.dlD().lNY != null && (list = fVar.dlD().lNY) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> bHD;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText dNQ = arrayList.get(i2).dNQ();
            if (dNQ != null && (bHD = dNQ.bHD()) != null) {
                int size = bHD.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (bHD.get(i4) != null && bHD.get(i4).getType() == 8) {
                        i3++;
                        if (bHD.get(i4).bHJ().bHW().equals(str) || bHD.get(i4).bHJ().bHX().equals(str)) {
                            int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = bHD.get(i4).bHJ().getWidth() * equipmentDensity;
                            int height = bHD.get(i4).bHJ().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.lVc = i4;
                            return dNQ;
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
            f pbData = this.moi.dmG().getPbData();
            TbRichText bH = bH(str, i);
            if (bH != null && (tbRichTextData = bH.bHD().get(this.lVc)) != null) {
                aVar.postId = String.valueOf(bH.getPostId());
                aVar.lPM = new ArrayList<>();
                aVar.eLn = new ConcurrentHashMap<>();
                if (!tbRichTextData.bHJ().bHU()) {
                    aVar.lPN = false;
                    String c = g.c(tbRichTextData);
                    aVar.lPM.add(c);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                        imageUrlData.urlType = 38;
                    } else {
                        imageUrlData.urlType = ((VideoPbViewModel) ViewModelProviders.of(this.moi.doq()).get(VideoPbViewModel.class)).isFromCDN() ? 17 : 18;
                    }
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                    imageUrlData.isLongPic = g(tbRichTextData);
                    imageUrlData.postId = bH.getPostId();
                    imageUrlData.mIsReserver = this.moi.dmG().dpc();
                    imageUrlData.mIsSeeHost = this.moi.dmG().getHostMode();
                    aVar.eLn.put(c, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.dlp() != null) {
                            aVar.threadId = pbData.dlp().getId();
                        }
                        aVar.eLl = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.lPN = true;
                int size = pbData.dlr().size();
                this.lVd = false;
                aVar.index = -1;
                int a2 = pbData.dly() != null ? a(pbData.dly().dNQ(), bH, i, i, aVar.lPM, aVar.eLn) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.dlr().get(i2);
                    if (postData.getId() == null || pbData.dly() == null || pbData.dly().getId() == null || !postData.getId().equals(pbData.dly().getId())) {
                        a2 = a(postData.dNQ(), bH, a2, i, aVar.lPM, aVar.eLn);
                    }
                }
                if (aVar.lPM.size() > 0) {
                    aVar.lastId = aVar.lPM.get(aVar.lPM.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.dlp() != null) {
                        aVar.threadId = pbData.dlp().getId();
                    }
                    aVar.eLl = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bHJ;
        String str;
        if (tbRichText == tbRichText2) {
            this.lVd = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.bHD().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.bHD().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.bHJ().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.bHJ().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.bHJ().bHU()) {
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
                            if (tbRichTextData != null && (bHJ = tbRichTextData.bHJ()) != null) {
                                String bHW = bHJ.bHW();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = bHJ.bHX();
                                } else {
                                    imageUrlData.urlType = ((VideoPbViewModel) ViewModelProviders.of(this.moi.doq()).get(VideoPbViewModel.class)).isFromCDN() ? 17 : 18;
                                    str = bHW;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.moi.dmG().doJ(), -1L);
                                imageUrlData.mIsReserver = this.moi.dmG().dpc();
                                imageUrlData.mIsSeeHost = this.moi.dmG().getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c, imageUrlData);
                                }
                            }
                        }
                        if (!this.lVd) {
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
        if (tbRichTextData == null || tbRichTextData.bHJ() == null) {
            return null;
        }
        return tbRichTextData.bHJ().bHZ();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bHJ() == null) {
            return 0L;
        }
        return tbRichTextData.bHJ().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bHJ() == null) {
            return false;
        }
        return tbRichTextData.bHJ().bIa();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bHJ() == null) {
            return false;
        }
        return tbRichTextData.bHJ().bIb();
    }

    public TbRichTextView.i getOnImageClickListener() {
        return this.fVW;
    }

    public c dve() {
        return this.fxj;
    }
}
