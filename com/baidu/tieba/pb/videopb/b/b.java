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
import com.baidu.tieba.pb.videopb.e;
import com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes21.dex */
public class b {
    public BaseVideoPBReplyFragment lOd;
    public VideoPbFragment lOe;
    private int lvp = 0;
    boolean lvq = false;
    private final TbRichTextView.i fFy = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.videopb.b.b.1
        /* JADX DEBUG: Multi-variable search result rejected for r6v16, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:30:0x014a A[Catch: Exception -> 0x02e3, TryCatch #0 {Exception -> 0x02e3, blocks: (B:3:0x0003, B:5:0x0045, B:7:0x0072, B:9:0x0084, B:11:0x0090, B:13:0x009a, B:14:0x00a4, B:16:0x00aa, B:18:0x00b0, B:21:0x00c1, B:24:0x00d2, B:25:0x0108, B:28:0x0111, B:30:0x014a, B:32:0x0176, B:33:0x0189, B:35:0x01ca, B:37:0x01d8, B:39:0x01f2, B:40:0x0202, B:42:0x0262, B:44:0x028e, B:45:0x02a1, B:49:0x02ed, B:51:0x02f5, B:53:0x02fd, B:55:0x030d, B:56:0x0326, B:58:0x032e, B:60:0x033c, B:61:0x0341, B:63:0x034b, B:65:0x0355, B:67:0x035f, B:68:0x0363, B:70:0x0369, B:72:0x0373, B:74:0x0389, B:75:0x03a3, B:77:0x03ae, B:78:0x03be, B:80:0x0412, B:82:0x043e, B:83:0x0451), top: B:86:0x0003 }] */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view, String str, int i, boolean z, boolean z2) {
            com.baidu.tieba.pb.videopb.fragment.a drk;
            int i2;
            int i3 = 0;
            try {
                ar arVar = new ar("c13398");
                arVar.dR("tid", b.this.lOd.diV().dkU());
                arVar.dR("fid", b.this.lOd.diV().getForumId());
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                arVar.ak("obj_locate", 3);
                arVar.ak("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(arVar);
                TiebaStatic.eventStat(b.this.lOd.getPageContext().getPageActivity(), "pic_pb", "");
                if (b.this.lOd.diV().getPbData().dik()) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    if (view.getParent() instanceof TbRichTextView) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                        if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bFc() != null) {
                            ArrayList<TbRichTextImageInfo> bFc = tbRichTextView.getRichText().bFc();
                            int i4 = 0;
                            i2 = -1;
                            while (i4 < bFc.size()) {
                                if (bFc.get(i4) != null) {
                                    arrayList.add(bFc.get(i4).getSrc());
                                    if (i2 == -1 && str != null && str.equals(bFc.get(i4).getSrc())) {
                                        i2 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bFc.get(i4).getSrc();
                                    imageUrlData.originalUrl = bFc.get(i4).getSrc();
                                    imageUrlData.isLongPic = bFc.get(i4).bFC();
                                    concurrentHashMap.put(bFc.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i2 = i2;
                            }
                            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                            aVar.x(arrayList).nL(i2).iy(false).iz(b.this.lOd.diV().dlm()).a(concurrentHashMap).iA(true).iB(false);
                            if (b.this.lOd.diV() != null) {
                                aVar.iC(b.this.lOd.diV().getHostMode());
                                aVar.Ae(b.this.lOd.diV().getFromForumId());
                                if (b.this.lOd.diV().getPbData() != null) {
                                    aVar.s(b.this.lOd.diV().getPbData().dhH());
                                }
                            }
                            ImageViewerConfig dU = aVar.dU(b.this.lOd.getPageContext().getPageActivity());
                            dU.getIntent().putExtra("from", "pb");
                            b.this.lOd.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                    }
                    i2 = -1;
                    ImageViewerConfig.a aVar2 = new ImageViewerConfig.a();
                    aVar2.x(arrayList).nL(i2).iy(false).iz(b.this.lOd.diV().dlm()).a(concurrentHashMap).iA(true).iB(false);
                    if (b.this.lOd.diV() != null) {
                    }
                    ImageViewerConfig dU2 = aVar2.dU(b.this.lOd.getPageContext().getPageActivity());
                    dU2.getIntent().putExtra("from", "pb");
                    b.this.lOd.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU2));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                PbActivity.a aVar3 = new PbActivity.a();
                b.this.a(str, i, aVar3);
                if (aVar3.lqq) {
                    TbRichText by = b.this.by(str, i);
                    if (by != null && b.this.lvp >= 0 && b.this.lvp < by.bFb().size()) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        String c = g.c(by.bFb().get(b.this.lvp));
                        while (true) {
                            if (i3 >= aVar3.lqp.size()) {
                                break;
                            } else if (!aVar3.lqp.get(i3).equals(c)) {
                                i3++;
                            } else {
                                aVar3.index = i3;
                                arrayList2.add(c);
                                break;
                            }
                        }
                        if (by.getPostId() != 0 && (drk = b.this.lOd.drk()) != null) {
                            ArrayList<q> dataList = drk.getDataList();
                            if (y.getCount(dataList) > 0) {
                                Iterator<q> it = dataList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    q next = it.next();
                                    if ((next instanceof PostData) && by.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                        com.baidu.tieba.pb.c.a.a(b.this.lOd.diV().getPbData(), (PostData) next, ((PostData) next).locate, 8, 3);
                                        break;
                                    }
                                }
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                        if (!y.isEmpty(arrayList2)) {
                            String str2 = arrayList2.get(0);
                            concurrentHashMap2.put(str2, aVar3.evM.get(str2));
                        }
                        ImageViewerConfig.a aVar4 = new ImageViewerConfig.a();
                        aVar4.x(arrayList2).zZ(aVar3.forumName).Aa(aVar3.forumId).Ab(aVar3.threadId).iy(aVar3.evK).iA(true).Ac(aVar3.lastId).a(concurrentHashMap2).iB(false).iz(b.this.lOd.diV().dlm()).Ad(aVar3.postId);
                        if (b.this.lOd.diV() != null) {
                            aVar4.iC(b.this.lOd.diV().getHostMode());
                            aVar4.Ae(b.this.lOd.diV().getFromForumId());
                            if (b.this.lOd.diV().getPbData() != null) {
                                aVar4.s(b.this.lOd.diV().getPbData().dhH());
                            }
                        }
                        ImageViewerConfig dU3 = aVar4.dU(b.this.lOd.getPageContext().getPageActivity());
                        dU3.getIntent().putExtra("from", "pb");
                        b.this.lOd.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(y.getItem(aVar3.lqp, 0));
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                if (!y.isEmpty(arrayList3)) {
                    String str3 = (String) arrayList3.get(0);
                    concurrentHashMap3.put(str3, aVar3.evM.get(str3));
                }
                ImageViewerConfig.a aVar5 = new ImageViewerConfig.a();
                aVar5.x(arrayList3).zZ(aVar3.forumName).Aa(aVar3.forumId).Ab(aVar3.threadId).iy(aVar3.evK).iA(true).Ac(aVar3.lqp.get(0)).a(concurrentHashMap3).iz(b.this.lOd.diV().dlm()).iB(false).Ad(aVar3.postId).iD(false);
                if (b.this.lOd.diV() != null) {
                    aVar5.iC(b.this.lOd.diV().getHostMode());
                    aVar5.Ae(b.this.lOd.diV().getFromForumId());
                    if (b.this.lOd.diV().getPbData() != null) {
                        aVar5.s(b.this.lOd.diV().getPbData().dhH());
                    }
                }
                ImageViewerConfig dU4 = aVar5.dU(b.this.lOd.getPageContext().getPageActivity());
                dU4.getIntent().putExtra("from", "pb");
                b.this.lOd.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU4));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    private c fgS = new c(new c.a() { // from class: com.baidu.tieba.pb.videopb.b.b.2
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
            if (b.this.lOe == null || !b.this.lOe.isAdded()) {
                return true;
            }
            if (view != null) {
                if (view.getId() == R.id.richText) {
                    if (b.this.lOe != null && b.this.lOe.dm(view)) {
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
            if (b.this.lOe != null) {
                b.this.lOe.dqz();
            }
            return true;
        }
    });

    public b(BaseVideoPBReplyFragment baseVideoPBReplyFragment) {
        this.lOd = baseVideoPBReplyFragment;
        this.lOe = baseVideoPBReplyFragment.dkA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (this.lOd.checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.lOd.diV() != null && this.lOd.diV().getPbData() != null && postData.dJQ() != 1) {
            String dkU = this.lOd.diV().dkU();
            String id = postData.getId();
            int dhW = this.lOd.diV().getPbData() != null ? this.lOd.diV().getPbData().dhW() : 0;
            PbActivity.a OZ = OZ(id);
            if (OZ != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.lOd.getPageContext().getPageActivity()).createSubPbActivityConfig(dkU, id, "pb", true, null, false, null, dhW, postData.dpH(), this.lOd.diV().getPbData().getAnti(), false, postData.blC() != null ? postData.blC().getIconInfo() : null).addBigImageData(OZ.lqp, OZ.evM, OZ.evK, OZ.index);
                addBigImageData.setKeyPageStartFrom(this.lOd.diV().dlE());
                addBigImageData.setFromFrsForumId(this.lOd.diV().getFromForumId());
                addBigImageData.setKeyFromForumId(this.lOd.diV().getForumId());
                addBigImageData.setBjhData(this.lOd.diV().dld());
                this.lOd.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    public PbActivity.a OZ(String str) {
        String str2;
        if (this.lOd.diV() == null || this.lOd.diV().getPbData() == null || this.lOd.diV().getPbData().dhJ() == null || this.lOd.diV().getPbData().dhJ().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.lOd.diV().getPbData().dhJ().size()) {
                i = 0;
                break;
            } else if (str.equals(this.lOd.diV().getPbData().dhJ().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.lOd.diV().getPbData().dhJ().get(i);
        if (postData.dJS() == null || postData.dJS().bFb() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.dJS().bFb().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.bFh() != null) {
                    str2 = next.bFh().bFx();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        g.a(postData, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText by(String str, int i) {
        TbRichText tbRichText = null;
        if (this.lOd.diV() == null || this.lOd.diV().getPbData() == null || str == null || i < 0) {
            return null;
        }
        f pbData = this.lOd.diV().getPbData();
        if (pbData.dhQ() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.dhQ());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> dhJ = pbData.dhJ();
            c(pbData, dhJ);
            return c(dhJ, str, i);
        }
        return tbRichText;
    }

    private void c(f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.dhV() != null && fVar.dhV().loU != null && (list = fVar.dhV().loU) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> bFb;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText dJS = arrayList.get(i2).dJS();
            if (dJS != null && (bFb = dJS.bFb()) != null) {
                int size = bFb.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (bFb.get(i4) != null && bFb.get(i4).getType() == 8) {
                        i3++;
                        if (bFb.get(i4).bFh().bFx().equals(str) || bFb.get(i4).bFh().bFy().equals(str)) {
                            int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = bFb.get(i4).bFh().getWidth() * equipmentDensity;
                            int height = bFb.get(i4).bFh().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.lvp = i4;
                            return dJS;
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
            f pbData = this.lOd.diV().getPbData();
            TbRichText by = by(str, i);
            if (by != null && (tbRichTextData = by.bFb().get(this.lvp)) != null) {
                aVar.postId = String.valueOf(by.getPostId());
                aVar.lqp = new ArrayList<>();
                aVar.evM = new ConcurrentHashMap<>();
                if (!tbRichTextData.bFh().bFv()) {
                    aVar.lqq = false;
                    String c = g.c(tbRichTextData);
                    aVar.lqp.add(c);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                        imageUrlData.urlType = 38;
                    } else {
                        imageUrlData.urlType = ((e) android.arch.lifecycle.y.b(this.lOd.dkB()).l(e.class)).isFromCDN() ? 17 : 18;
                    }
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                    imageUrlData.isLongPic = g(tbRichTextData);
                    imageUrlData.postId = by.getPostId();
                    imageUrlData.mIsReserver = this.lOd.diV().dlm();
                    imageUrlData.mIsSeeHost = this.lOd.diV().getHostMode();
                    aVar.evM.put(c, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.dhH() != null) {
                            aVar.threadId = pbData.dhH().getId();
                        }
                        aVar.evK = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.lqq = true;
                int size = pbData.dhJ().size();
                this.lvq = false;
                aVar.index = -1;
                int a2 = pbData.dhQ() != null ? a(pbData.dhQ().dJS(), by, i, i, aVar.lqp, aVar.evM) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.dhJ().get(i2);
                    if (postData.getId() == null || pbData.dhQ() == null || pbData.dhQ().getId() == null || !postData.getId().equals(pbData.dhQ().getId())) {
                        a2 = a(postData.dJS(), by, a2, i, aVar.lqp, aVar.evM);
                    }
                }
                if (aVar.lqp.size() > 0) {
                    aVar.lastId = aVar.lqp.get(aVar.lqp.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.dhH() != null) {
                        aVar.threadId = pbData.dhH().getId();
                    }
                    aVar.evK = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bFh;
        String str;
        if (tbRichText == tbRichText2) {
            this.lvq = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.bFb().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.bFb().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.bFh().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.bFh().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.bFh().bFv()) {
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
                            if (tbRichTextData != null && (bFh = tbRichTextData.bFh()) != null) {
                                String bFx = bFh.bFx();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = bFh.bFy();
                                } else {
                                    imageUrlData.urlType = ((e) android.arch.lifecycle.y.b(this.lOd.dkB()).l(e.class)).isFromCDN() ? 17 : 18;
                                    str = bFx;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.lOd.diV().dkU(), -1L);
                                imageUrlData.mIsReserver = this.lOd.diV().dlm();
                                imageUrlData.mIsSeeHost = this.lOd.diV().getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c, imageUrlData);
                                }
                            }
                        }
                        if (!this.lvq) {
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
        if (tbRichTextData == null || tbRichTextData.bFh() == null) {
            return null;
        }
        return tbRichTextData.bFh().bFA();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bFh() == null) {
            return 0L;
        }
        return tbRichTextData.bFh().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bFh() == null) {
            return false;
        }
        return tbRichTextData.bFh().bFB();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bFh() == null) {
            return false;
        }
        return tbRichTextData.bFh().bFC();
    }

    public TbRichTextView.i getOnImageClickListener() {
        return this.fFy;
    }

    public c drj() {
        return this.fgS;
    }
}
