package com.baidu.tieba.pb.videopb.b;

import android.arch.lifecycle.y;
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
import com.baidu.tbadk.core.util.ap;
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
import com.baidu.tieba.pb.videopb.e;
import com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes16.dex */
public class b {
    public BaseVideoPBReplyFragment kHF;
    public VideoPbFragment kHG;
    private int kpp = 0;
    boolean kpq = false;
    private final TbRichTextView.i eRR = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.videopb.b.b.1
        /* JADX DEBUG: Multi-variable search result rejected for r6v16, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            com.baidu.tieba.pb.videopb.fragment.a cTR;
            int i2;
            ImageViewerConfig.a aVar;
            int i3 = 0;
            try {
                ap apVar = new ap("c13398");
                apVar.dn("tid", b.this.kHF.cLP().cNL());
                apVar.dn("fid", b.this.kHF.cLP().getForumId());
                apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
                apVar.ah("obj_locate", 3);
                apVar.ah("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(apVar);
                TiebaStatic.eventStat(b.this.kHF.getPageContext().getPageActivity(), "pic_pb", "");
                if (b.this.kHF.cLP().getPbData().cLa()) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    if (view.getParent() instanceof TbRichTextView) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                        if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().boK() != null) {
                            ArrayList<TbRichTextImageInfo> boK = tbRichTextView.getRichText().boK();
                            int i4 = 0;
                            i2 = -1;
                            while (i4 < boK.size()) {
                                if (boK.get(i4) != null) {
                                    arrayList.add(boK.get(i4).getSrc());
                                    if (i2 == -1 && str != null && str.equals(boK.get(i4).getSrc())) {
                                        i2 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = boK.get(i4).getSrc();
                                    imageUrlData.originalUrl = boK.get(i4).getSrc();
                                    imageUrlData.isLongPic = boK.get(i4).bpj();
                                    concurrentHashMap.put(boK.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i2 = i2;
                            }
                            aVar = new ImageViewerConfig.a();
                            aVar.s(arrayList).kG(i2).hl(false).hm(b.this.kHF.cLP().cOd()).hp(z).a(concurrentHashMap).hn(true).ho(false);
                            if (b.this.kHF.cLP() != null && b.this.kHF.cLP().getPbData() != null) {
                                aVar.r(b.this.kHF.cLP().getPbData().cKx());
                            }
                            ImageViewerConfig dI = aVar.dI(b.this.kHF.getPageContext().getPageActivity());
                            dI.getIntent().putExtra("from", "pb");
                            b.this.kHF.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dI));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                    }
                    i2 = -1;
                    aVar = new ImageViewerConfig.a();
                    aVar.s(arrayList).kG(i2).hl(false).hm(b.this.kHF.cLP().cOd()).hp(z).a(concurrentHashMap).hn(true).ho(false);
                    if (b.this.kHF.cLP() != null) {
                        aVar.r(b.this.kHF.cLP().getPbData().cKx());
                    }
                    ImageViewerConfig dI2 = aVar.dI(b.this.kHF.getPageContext().getPageActivity());
                    dI2.getIntent().putExtra("from", "pb");
                    b.this.kHF.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dI2));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                PbActivity.a aVar2 = new PbActivity.a();
                b.this.a(str, i, aVar2);
                if (aVar2.kku) {
                    TbRichText br = b.this.br(str, i);
                    if (br != null && b.this.kpp >= 0 && b.this.kpp < br.boJ().size()) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        String c = g.c(br.boJ().get(b.this.kpp));
                        while (true) {
                            if (i3 >= aVar2.kkt.size()) {
                                break;
                            } else if (!aVar2.kkt.get(i3).equals(c)) {
                                i3++;
                            } else {
                                aVar2.index = i3;
                                arrayList2.add(c);
                                break;
                            }
                        }
                        if (br.getPostId() != 0 && (cTR = b.this.kHF.cTR()) != null) {
                            ArrayList<q> dataList = cTR.getDataList();
                            if (x.getCount(dataList) > 0) {
                                Iterator<q> it = dataList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    q next = it.next();
                                    if ((next instanceof PostData) && br.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                        com.baidu.tieba.pb.c.a.a(b.this.kHF.cLP().getPbData(), (PostData) next, ((PostData) next).locate, 8, 3);
                                        break;
                                    }
                                }
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                        if (!x.isEmpty(arrayList2)) {
                            String str2 = arrayList2.get(0);
                            concurrentHashMap2.put(str2, aVar2.dLG.get(str2));
                        }
                        ImageViewerConfig.a aVar3 = new ImageViewerConfig.a();
                        aVar3.s(arrayList2).wE(aVar2.forumName).wF(aVar2.forumId).wG(aVar2.threadId).hl(aVar2.dLE).hn(true).wH(aVar2.lastId).a(concurrentHashMap2).ho(false).hm(b.this.kHF.cLP().cOd()).hp(z).wI(aVar2.postId);
                        if (b.this.kHF.cLP() != null && b.this.kHF.cLP().getPbData() != null) {
                            aVar3.r(b.this.kHF.cLP().getPbData().cKx());
                        }
                        ImageViewerConfig dI3 = aVar3.dI(b.this.kHF.getPageContext().getPageActivity());
                        dI3.getIntent().putExtra("from", "pb");
                        b.this.kHF.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dI3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(x.getItem(aVar2.kkt, 0));
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                if (!x.isEmpty(arrayList3)) {
                    String str3 = (String) arrayList3.get(0);
                    concurrentHashMap3.put(str3, aVar2.dLG.get(str3));
                }
                ImageViewerConfig.a aVar4 = new ImageViewerConfig.a();
                aVar4.s(arrayList3).wE(aVar2.forumName).wF(aVar2.forumId).wG(aVar2.threadId).hl(aVar2.dLE).hn(true).wH(aVar2.kkt.get(0)).a(concurrentHashMap3).hm(b.this.kHF.cLP().cOd()).hp(z).ho(false).wI(aVar2.postId).hq(false);
                if (b.this.kHF.cLP() != null && b.this.kHF.cLP().getPbData() != null) {
                    aVar4.r(b.this.kHF.cLP().getPbData().cKx());
                }
                ImageViewerConfig dI4 = aVar4.dI(b.this.kHF.getPageContext().getPageActivity());
                dI4.getIntent().putExtra("from", "pb");
                b.this.kHF.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dI4));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    private c euG = new c(new c.a() { // from class: com.baidu.tieba.pb.videopb.b.b.2
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
            if (b.this.kHG == null || !b.this.kHG.isAdded()) {
                return true;
            }
            if (view != null) {
                if (view.getId() == R.id.richText) {
                    if (b.this.kHG != null && b.this.kHG.cI(view)) {
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
            if (b.this.kHG != null) {
                b.this.kHG.cTj();
            }
            return true;
        }
    });

    public b(BaseVideoPBReplyFragment baseVideoPBReplyFragment) {
        this.kHF = baseVideoPBReplyFragment;
        this.kHG = baseVideoPBReplyFragment.cNs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (this.kHF.checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.kHF.cLP() != null && this.kHF.cLP().getPbData() != null && postData.dli() != 1) {
            String cNL = this.kHF.cLP().cNL();
            String id = postData.getId();
            int cKM = this.kHF.cLP().getPbData() != null ? this.kHF.cLP().getPbData().cKM() : 0;
            PbActivity.a KE = KE(id);
            if (KE != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.kHF.getPageContext().getPageActivity()).createSubPbActivityConfig(cNL, id, "pb", true, null, false, null, cKM, postData.cSs(), this.kHF.cLP().getPbData().getAnti(), false, postData.aWl() != null ? postData.aWl().getIconInfo() : null).addBigImageData(KE.kkt, KE.dLG, KE.dLE, KE.index);
                addBigImageData.setKeyPageStartFrom(this.kHF.cLP().cOv());
                addBigImageData.setFromFrsForumId(this.kHF.cLP().getFromForumId());
                addBigImageData.setKeyFromForumId(this.kHF.cLP().getForumId());
                addBigImageData.setBjhData(this.kHF.cLP().cNU());
                this.kHF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    public PbActivity.a KE(String str) {
        String str2;
        if (this.kHF.cLP() == null || this.kHF.cLP().getPbData() == null || this.kHF.cLP().getPbData().cKz() == null || this.kHF.cLP().getPbData().cKz().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.kHF.cLP().getPbData().cKz().size()) {
                i = 0;
                break;
            } else if (str.equals(this.kHF.cLP().getPbData().cKz().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.kHF.cLP().getPbData().cKz().get(i);
        if (postData.dlk() == null || postData.dlk().boJ() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.dlk().boJ().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.boP() != null) {
                    str2 = next.boP().bpe();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        g.a(postData, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText br(String str, int i) {
        TbRichText tbRichText = null;
        if (this.kHF.cLP() == null || this.kHF.cLP().getPbData() == null || str == null || i < 0) {
            return null;
        }
        f pbData = this.kHF.cLP().getPbData();
        if (pbData.cKG() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.cKG());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> cKz = pbData.cKz();
            c(pbData, cKz);
            return c(cKz, str, i);
        }
        return tbRichText;
    }

    private void c(f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.cKL() != null && fVar.cKL().kiW != null && (list = fVar.cKL().kiW) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> boJ;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText dlk = arrayList.get(i2).dlk();
            if (dlk != null && (boJ = dlk.boJ()) != null) {
                int size = boJ.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (boJ.get(i4) != null && boJ.get(i4).getType() == 8) {
                        i3++;
                        if (boJ.get(i4).boP().bpe().equals(str) || boJ.get(i4).boP().bpf().equals(str)) {
                            int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = boJ.get(i4).boP().getWidth() * equipmentDensity;
                            int height = boJ.get(i4).boP().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.kpp = i4;
                            return dlk;
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
            f pbData = this.kHF.cLP().getPbData();
            TbRichText br = br(str, i);
            if (br != null && (tbRichTextData = br.boJ().get(this.kpp)) != null) {
                aVar.postId = String.valueOf(br.getPostId());
                aVar.kkt = new ArrayList<>();
                aVar.dLG = new ConcurrentHashMap<>();
                if (!tbRichTextData.boP().bpc()) {
                    aVar.kku = false;
                    String c = g.c(tbRichTextData);
                    aVar.kkt.add(c);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                        imageUrlData.urlType = 38;
                    } else {
                        imageUrlData.urlType = ((e) y.b(this.kHF.cNt()).l(e.class)).isFromCDN() ? 17 : 18;
                    }
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                    imageUrlData.isLongPic = g(tbRichTextData);
                    imageUrlData.postId = br.getPostId();
                    imageUrlData.mIsReserver = this.kHF.cLP().cOd();
                    imageUrlData.mIsSeeHost = this.kHF.cLP().getHostMode();
                    aVar.dLG.put(c, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.cKx() != null) {
                            aVar.threadId = pbData.cKx().getId();
                        }
                        aVar.dLE = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.kku = true;
                int size = pbData.cKz().size();
                this.kpq = false;
                aVar.index = -1;
                int a = pbData.cKG() != null ? a(pbData.cKG().dlk(), br, i, i, aVar.kkt, aVar.dLG) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.cKz().get(i2);
                    if (postData.getId() == null || pbData.cKG() == null || pbData.cKG().getId() == null || !postData.getId().equals(pbData.cKG().getId())) {
                        a = a(postData.dlk(), br, a, i, aVar.kkt, aVar.dLG);
                    }
                }
                if (aVar.kkt.size() > 0) {
                    aVar.lastId = aVar.kkt.get(aVar.kkt.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.cKx() != null) {
                        aVar.threadId = pbData.cKx().getId();
                    }
                    aVar.dLE = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a;
            }
        }
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo boP;
        String str;
        if (tbRichText == tbRichText2) {
            this.kpq = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.boJ().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.boJ().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.boP().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.boP().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.boP().bpc()) {
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
                            if (tbRichTextData != null && (boP = tbRichTextData.boP()) != null) {
                                String bpe = boP.bpe();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = boP.bpf();
                                } else {
                                    imageUrlData.urlType = ((e) y.b(this.kHF.cNt()).l(e.class)).isFromCDN() ? 17 : 18;
                                    str = bpe;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.kHF.cLP().cNL(), -1L);
                                imageUrlData.mIsReserver = this.kHF.cLP().cOd();
                                imageUrlData.mIsSeeHost = this.kHF.cLP().getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c, imageUrlData);
                                }
                            }
                        }
                        if (!this.kpq) {
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
        if (tbRichTextData == null || tbRichTextData.boP() == null) {
            return null;
        }
        return tbRichTextData.boP().bph();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.boP() == null) {
            return 0L;
        }
        return tbRichTextData.boP().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.boP() == null) {
            return false;
        }
        return tbRichTextData.boP().bpi();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.boP() == null) {
            return false;
        }
        return tbRichTextData.boP().bpj();
    }

    public TbRichTextView.i getOnImageClickListener() {
        return this.eRR;
    }

    public c cTQ() {
        return this.euG;
    }
}
