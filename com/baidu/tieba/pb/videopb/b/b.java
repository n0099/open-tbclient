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
    public BaseVideoPBReplyFragment mhv;
    public VideoPbFragment mhw;
    private int lOt = 0;
    boolean lOu = false;
    private final TbRichTextView.i fWO = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.videopb.b.b.1
        /* JADX DEBUG: Multi-variable search result rejected for r6v15, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0149 A[Catch: Exception -> 0x02e2, TryCatch #0 {Exception -> 0x02e2, blocks: (B:3:0x0003, B:5:0x0045, B:7:0x0072, B:9:0x0084, B:11:0x0090, B:13:0x009a, B:14:0x00a3, B:16:0x00a9, B:18:0x00af, B:21:0x00c0, B:24:0x00d1, B:25:0x0107, B:28:0x0110, B:30:0x0149, B:32:0x0175, B:33:0x0188, B:35:0x01c9, B:37:0x01d7, B:39:0x01f1, B:40:0x0201, B:42:0x0261, B:44:0x028d, B:45:0x02a0, B:49:0x02ec, B:51:0x02f4, B:53:0x02fc, B:55:0x030c, B:56:0x0326, B:58:0x032e, B:60:0x033c, B:61:0x0341, B:63:0x034b, B:65:0x0355, B:67:0x035f, B:68:0x0363, B:70:0x0369, B:72:0x0373, B:74:0x0389, B:75:0x03a3, B:77:0x03ae, B:78:0x03be, B:80:0x0412, B:82:0x043e, B:83:0x0451), top: B:86:0x0003 }] */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view, String str, int i, boolean z, boolean z2) {
            com.baidu.tieba.pb.videopb.fragment.a dwt;
            int i2;
            int i3 = 0;
            try {
                aq aqVar = new aq("c13398");
                aqVar.dX("tid", b.this.mhv.dnV().dpW());
                aqVar.dX("fid", b.this.mhv.dnV().getForumId());
                aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.an("obj_locate", 3);
                aqVar.an("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(aqVar);
                TiebaStatic.eventStat(b.this.mhv.getPageContext().getPageActivity(), "pic_pb", "");
                if (b.this.mhv.dnV().getPbData().dnh()) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    if (view.getParent() instanceof TbRichTextView) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                        if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bKX() != null) {
                            ArrayList<TbRichTextImageInfo> bKX = tbRichTextView.getRichText().bKX();
                            i2 = -1;
                            while (i3 < bKX.size()) {
                                if (bKX.get(i3) != null) {
                                    arrayList.add(bKX.get(i3).getSrc());
                                    if (i2 == -1 && str != null && str.equals(bKX.get(i3).getSrc())) {
                                        i2 = i3;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bKX.get(i3).getSrc();
                                    imageUrlData.originalUrl = bKX.get(i3).getSrc();
                                    imageUrlData.isLongPic = bKX.get(i3).bLu();
                                    concurrentHashMap.put(bKX.get(i3).getSrc(), imageUrlData);
                                }
                                i3++;
                                i2 = i2;
                            }
                            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                            aVar.x(arrayList).ot(i2).ji(false).jj(b.this.mhv.dnV().dqp()).d(concurrentHashMap).jk(true).jl(false);
                            if (b.this.mhv.dnV() != null) {
                                aVar.jm(b.this.mhv.dnV().getHostMode());
                                aVar.AJ(b.this.mhv.dnV().getFromForumId());
                                if (b.this.mhv.dnV().getPbData() != null) {
                                    aVar.s(b.this.mhv.dnV().getPbData().dmE());
                                }
                            }
                            ImageViewerConfig eS = aVar.eS(b.this.mhv.getPageContext().getPageActivity());
                            eS.getIntent().putExtra("from", "pb");
                            b.this.mhv.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eS));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                    }
                    i2 = -1;
                    ImageViewerConfig.a aVar2 = new ImageViewerConfig.a();
                    aVar2.x(arrayList).ot(i2).ji(false).jj(b.this.mhv.dnV().dqp()).d(concurrentHashMap).jk(true).jl(false);
                    if (b.this.mhv.dnV() != null) {
                    }
                    ImageViewerConfig eS2 = aVar2.eS(b.this.mhv.getPageContext().getPageActivity());
                    eS2.getIntent().putExtra("from", "pb");
                    b.this.mhv.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eS2));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                PbActivity.a aVar3 = new PbActivity.a();
                b.this.a(str, i, aVar3);
                if (aVar3.lJm) {
                    TbRichText bG = b.this.bG(str, i);
                    if (bG != null && b.this.lOt >= 0 && b.this.lOt < bG.bKW().size()) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        String c = g.c(bG.bKW().get(b.this.lOt));
                        int i4 = 0;
                        while (true) {
                            if (i4 >= aVar3.lJl.size()) {
                                break;
                            } else if (!aVar3.lJl.get(i4).equals(c)) {
                                i4++;
                            } else {
                                aVar3.index = i4;
                                arrayList2.add(c);
                                break;
                            }
                        }
                        if (bG.getPostId() != 0 && (dwt = b.this.mhv.dwt()) != null) {
                            ArrayList<n> dataList = dwt.getDataList();
                            if (x.getCount(dataList) > 0) {
                                Iterator<n> it = dataList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    n next = it.next();
                                    if ((next instanceof PostData) && bG.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                        com.baidu.tieba.pb.c.a.a(b.this.mhv.dnV().getPbData(), (PostData) next, ((PostData) next).locate, 8, 3);
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
                        aVar4.x(arrayList2).AE(aVar3.forumName).AF(aVar3.forumId).AG(aVar3.threadId).ji(aVar3.eMp).jk(true).AH(aVar3.lastId).d(concurrentHashMap2).jl(false).jj(b.this.mhv.dnV().dqp()).AI(aVar3.postId);
                        if (b.this.mhv.dnV() != null) {
                            aVar4.jm(b.this.mhv.dnV().getHostMode());
                            aVar4.AJ(b.this.mhv.dnV().getFromForumId());
                            if (b.this.mhv.dnV().getPbData() != null) {
                                aVar4.s(b.this.mhv.dnV().getPbData().dmE());
                            }
                        }
                        ImageViewerConfig eS3 = aVar4.eS(b.this.mhv.getPageContext().getPageActivity());
                        eS3.getIntent().putExtra("from", "pb");
                        b.this.mhv.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eS3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(x.getItem(aVar3.lJl, 0));
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                if (!x.isEmpty(arrayList3)) {
                    String str3 = (String) arrayList3.get(0);
                    concurrentHashMap3.put(str3, aVar3.eMr.get(str3));
                }
                ImageViewerConfig.a aVar5 = new ImageViewerConfig.a();
                aVar5.x(arrayList3).AE(aVar3.forumName).AF(aVar3.forumId).AG(aVar3.threadId).ji(aVar3.eMp).jk(true).AH(aVar3.lJl.get(0)).d(concurrentHashMap3).jj(b.this.mhv.dnV().dqp()).jl(false).AI(aVar3.postId).jn(false);
                if (b.this.mhv.dnV() != null) {
                    aVar5.jm(b.this.mhv.dnV().getHostMode());
                    aVar5.AJ(b.this.mhv.dnV().getFromForumId());
                    if (b.this.mhv.dnV().getPbData() != null) {
                        aVar5.s(b.this.mhv.dnV().getPbData().dmE());
                    }
                }
                ImageViewerConfig eS4 = aVar5.eS(b.this.mhv.getPageContext().getPageActivity());
                eS4.getIntent().putExtra("from", "pb");
                b.this.mhv.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eS4));
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
            if (b.this.mhw == null || !b.this.mhw.isAdded()) {
                return true;
            }
            if (view != null) {
                if (view.getId() == R.id.richText) {
                    if (b.this.mhw != null && b.this.mhw.dE(view)) {
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
            if (b.this.mhw != null) {
                b.this.mhw.dvI();
            }
            return true;
        }
    });

    public b(BaseVideoPBReplyFragment baseVideoPBReplyFragment) {
        this.mhv = baseVideoPBReplyFragment;
        this.mhw = baseVideoPBReplyFragment.dpC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(SparseArray<Object> sparseArray) {
        PostData postData;
        if (this.mhv.checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.mhv.dnV() != null && this.mhv.dnV().getPbData() != null && postData.dPd() != 1) {
            String dpW = this.mhv.dnV().dpW();
            String id = postData.getId();
            int dmT = this.mhv.dnV().getPbData() != null ? this.mhv.dnV().getPbData().dmT() : 0;
            PbActivity.a PN = PN(id);
            if (PN != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.mhv.getPageContext().getPageActivity()).createSubPbActivityConfig(dpW, id, "pb", true, null, false, null, dmT, postData.duO(), this.mhv.dnV().getPbData().getAnti(), false, postData.brq() != null ? postData.brq().getIconInfo() : null).addBigImageData(PN.lJl, PN.eMr, PN.eMp, PN.index);
                addBigImageData.setKeyPageStartFrom(this.mhv.dnV().dqH());
                addBigImageData.setFromFrsForumId(this.mhv.dnV().getFromForumId());
                addBigImageData.setKeyFromForumId(this.mhv.dnV().getForumId());
                addBigImageData.setBjhData(this.mhv.dnV().dqg());
                this.mhv.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    public PbActivity.a PN(String str) {
        String str2;
        if (this.mhv.dnV() == null || this.mhv.dnV().getPbData() == null || this.mhv.dnV().getPbData().dmG() == null || this.mhv.dnV().getPbData().dmG().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.mhv.dnV().getPbData().dmG().size()) {
                i = 0;
                break;
            } else if (str.equals(this.mhv.dnV().getPbData().dmG().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.mhv.dnV().getPbData().dmG().get(i);
        if (postData.dPf() == null || postData.dPf().bKW() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.dPf().bKW().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.bLc() != null) {
                    str2 = next.bLc().bLp();
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
        if (this.mhv.dnV() == null || this.mhv.dnV().getPbData() == null || str == null || i < 0) {
            return null;
        }
        f pbData = this.mhv.dnV().getPbData();
        if (pbData.dmN() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.dmN());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> dmG = pbData.dmG();
            c(pbData, dmG);
            return c(dmG, str, i);
        }
        return tbRichText;
    }

    private void c(f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.dmS() != null && fVar.dmS().lHy != null && (list = fVar.dmS().lHy) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> bKW;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText dPf = arrayList.get(i2).dPf();
            if (dPf != null && (bKW = dPf.bKW()) != null) {
                int size = bKW.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (bKW.get(i4) != null && bKW.get(i4).getType() == 8) {
                        i3++;
                        if (bKW.get(i4).bLc().bLp().equals(str) || bKW.get(i4).bLc().bLq().equals(str)) {
                            int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = bKW.get(i4).bLc().getWidth() * equipmentDensity;
                            int height = bKW.get(i4).bLc().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.lOt = i4;
                            return dPf;
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
            f pbData = this.mhv.dnV().getPbData();
            TbRichText bG = bG(str, i);
            if (bG != null && (tbRichTextData = bG.bKW().get(this.lOt)) != null) {
                aVar.postId = String.valueOf(bG.getPostId());
                aVar.lJl = new ArrayList<>();
                aVar.eMr = new ConcurrentHashMap<>();
                if (!tbRichTextData.bLc().bLn()) {
                    aVar.lJm = false;
                    String c = g.c(tbRichTextData);
                    aVar.lJl.add(c);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                        imageUrlData.urlType = 38;
                    } else {
                        imageUrlData.urlType = ((VideoPbViewModel) ViewModelProviders.of(this.mhv.dpD()).get(VideoPbViewModel.class)).isFromCDN() ? 17 : 18;
                    }
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                    imageUrlData.isLongPic = g(tbRichTextData);
                    imageUrlData.postId = bG.getPostId();
                    imageUrlData.mIsReserver = this.mhv.dnV().dqp();
                    imageUrlData.mIsSeeHost = this.mhv.dnV().getHostMode();
                    aVar.eMr.put(c, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.dmE() != null) {
                            aVar.threadId = pbData.dmE().getId();
                        }
                        aVar.eMp = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.lJm = true;
                int size = pbData.dmG().size();
                this.lOu = false;
                aVar.index = -1;
                int a2 = pbData.dmN() != null ? a(pbData.dmN().dPf(), bG, i, i, aVar.lJl, aVar.eMr) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.dmG().get(i2);
                    if (postData.getId() == null || pbData.dmN() == null || pbData.dmN().getId() == null || !postData.getId().equals(pbData.dmN().getId())) {
                        a2 = a(postData.dPf(), bG, a2, i, aVar.lJl, aVar.eMr);
                    }
                }
                if (aVar.lJl.size() > 0) {
                    aVar.lastId = aVar.lJl.get(aVar.lJl.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.dmE() != null) {
                        aVar.threadId = pbData.dmE().getId();
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
        TbRichTextImageInfo bLc;
        String str;
        if (tbRichText == tbRichText2) {
            this.lOu = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.bKW().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.bKW().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.bLc().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.bLc().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.bLc().bLn()) {
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
                            if (tbRichTextData != null && (bLc = tbRichTextData.bLc()) != null) {
                                String bLp = bLc.bLp();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = bLc.bLq();
                                } else {
                                    imageUrlData.urlType = ((VideoPbViewModel) ViewModelProviders.of(this.mhv.dpD()).get(VideoPbViewModel.class)).isFromCDN() ? 17 : 18;
                                    str = bLp;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.mhv.dnV().dpW(), -1L);
                                imageUrlData.mIsReserver = this.mhv.dnV().dqp();
                                imageUrlData.mIsSeeHost = this.mhv.dnV().getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c, imageUrlData);
                                }
                            }
                        }
                        if (!this.lOu) {
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
        if (tbRichTextData == null || tbRichTextData.bLc() == null) {
            return null;
        }
        return tbRichTextData.bLc().bLs();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bLc() == null) {
            return 0L;
        }
        return tbRichTextData.bLc().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bLc() == null) {
            return false;
        }
        return tbRichTextData.bLc().bLt();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bLc() == null) {
            return false;
        }
        return tbRichTextData.bLc().bLu();
    }

    public TbRichTextView.i getOnImageClickListener() {
        return this.fWO;
    }

    public c dws() {
        return this.fyb;
    }
}
