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
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.c;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class b {
    public ReplyFragment iZX;
    public VideoPbFragment iZY;
    private int iIH = 0;
    boolean iII = false;
    private final TbRichTextView.i dMx = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.videopb.b.b.1
        /* JADX DEBUG: Multi-variable search result rejected for r2v57, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            c ctF;
            try {
                an anVar = new an("c13398");
                anVar.cy("tid", b.this.iZX.clB().cny());
                anVar.cy("fid", b.this.iZX.clB().getForumId());
                anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.X("obj_locate", 3);
                anVar.X("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(anVar);
                TiebaStatic.eventStat(b.this.iZX.getPageContext().getPageActivity(), "pic_pb", "");
                if (b.this.iZX.clB().getPbData().ckS()) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    int i2 = -1;
                    if (view.getParent() instanceof TbRichTextView) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                        if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().aTT() != null) {
                            ArrayList<TbRichTextImageInfo> aTT = tbRichTextView.getRichText().aTT();
                            int i3 = 0;
                            while (i3 < aTT.size()) {
                                if (aTT.get(i3) != null) {
                                    arrayList.add(aTT.get(i3).getSrc());
                                    if (i2 == -1 && str != null && str.equals(aTT.get(i3).getSrc())) {
                                        i2 = i3;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = aTT.get(i3).getSrc();
                                    imageUrlData.originalUrl = aTT.get(i3).getSrc();
                                    imageUrlData.isLongPic = aTT.get(i3).aUq();
                                    concurrentHashMap.put(aTT.get(i3).getSrc(), imageUrlData);
                                }
                                i3++;
                                i2 = i2;
                            }
                        }
                    }
                    ImageViewerConfig createConfig = new ImageViewerConfig(b.this.iZX.getPageContext().getPageActivity()).createConfig(arrayList, i2, "", "", "", false, "", b.this.iZX.clB().cnP(), concurrentHashMap, true, false, z);
                    createConfig.getIntent().putExtra("from", "pb");
                    if (b.this.iZX.clB() != null && b.this.iZX.clB().getPbData() != null) {
                        createConfig.setThreadData(b.this.iZX.clB().getPbData().cku());
                    }
                    b.this.iZX.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                PbActivity.a aVar = new PbActivity.a();
                b.this.a(str, i, aVar);
                if (aVar.iEq) {
                    TbRichText bj = b.this.bj(str, i);
                    if (bj != null && b.this.iIH >= 0 && b.this.iIH < bj.aTS().size()) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        String b = f.b(bj.aTS().get(b.this.iIH));
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            if (i5 >= aVar.iEn.size()) {
                                break;
                            } else if (!aVar.iEn.get(i5).equals(b)) {
                                i4 = i5 + 1;
                            } else {
                                aVar.index = i5;
                                arrayList2.add(b);
                                break;
                            }
                        }
                        if (bj.getPostId() != 0 && (ctF = b.this.iZX.ctF()) != null) {
                            ArrayList<m> dataList = ctF.getDataList();
                            if (v.getCount(dataList) > 0) {
                                Iterator<m> it = dataList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    m next = it.next();
                                    if ((next instanceof PostData) && bj.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                        com.baidu.tieba.pb.c.a.a(b.this.iZX.clB().getPbData(), (PostData) next, ((PostData) next).locate, 8, 3);
                                        break;
                                    }
                                }
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                        if (!v.isEmpty(arrayList2)) {
                            String str2 = arrayList2.get(0);
                            concurrentHashMap2.put(str2, aVar.iEo.get(str2));
                        }
                        ImageViewerConfig createConfig2 = new ImageViewerConfig(b.this.iZX.getPageContext().getPageActivity()).createConfig(arrayList2, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.iEp, aVar.lastId, b.this.iZX.clB().cnP(), concurrentHashMap2, true, false, z);
                        createConfig2.getIntent().putExtra("from", "pb");
                        createConfig2.setPostId(aVar.postId);
                        if (b.this.iZX.clB() != null && b.this.iZX.clB().getPbData() != null) {
                            createConfig2.setThreadData(b.this.iZX.clB().getPbData().cku());
                        }
                        b.this.iZX.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(v.getItem(aVar.iEn, 0));
                ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                if (!v.isEmpty(arrayList3)) {
                    String str3 = (String) arrayList3.get(0);
                    concurrentHashMap3.put(str3, aVar.iEo.get(str3));
                }
                ImageViewerConfig createConfig3 = new ImageViewerConfig(b.this.iZX.getPageContext().getPageActivity()).createConfig(arrayList3, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.iEp, aVar.iEn.get(0), b.this.iZX.clB().cnP(), concurrentHashMap3, true, false, z);
                createConfig3.getIntent().putExtra("from", "pb");
                createConfig3.setIsCanDrag(false);
                createConfig3.setPostId(aVar.postId);
                if (b.this.iZX.clB() != null && b.this.iZX.clB().getPbData() != null) {
                    createConfig3.setThreadData(b.this.iZX.clB().getPbData().cku());
                }
                b.this.iZX.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    private com.baidu.tieba.pb.a.c dqK = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.videopb.b.b.2
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
            if (b.this.iZY == null || !b.this.iZY.isAdded()) {
                return true;
            }
            if (view != null) {
                if (view.getId() == R.id.richText) {
                    if (b.this.iZY != null && b.this.iZY.ct(view)) {
                        return true;
                    }
                } else if (view.getId() == R.id.pb_floor_item_layout) {
                    if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                        b.this.c((SparseArray) view.getTag(R.id.tag_from));
                    }
                } else if ((view instanceof TbRichTextView) || view.getId() == R.id.pb_post_header_layout) {
                    SparseArray sparseArray = null;
                    if (view.getTag() instanceof SparseArray) {
                        sparseArray = (SparseArray) view.getTag();
                    }
                    if (sparseArray != null) {
                        b.this.c(sparseArray);
                    } else {
                        return false;
                    }
                }
            }
            if (b.this.iZY != null) {
                b.this.iZY.csR();
            }
            return true;
        }
    });

    public b(ReplyFragment replyFragment) {
        this.iZX = replyFragment;
        this.iZY = replyFragment.cnh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SparseArray<Object> sparseArray) {
        PostData postData;
        if (this.iZX.checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.iZX.clB() != null && this.iZX.clB().getPbData() != null && postData.cLa() != 1) {
            String cny = this.iZX.clB().cny();
            String id = postData.getId();
            int ckG = this.iZX.clB().getPbData() != null ? this.iZX.clB().getPbData().ckG() : 0;
            PbActivity.a FS = FS(id);
            if (FS != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.iZX.getPageContext().getPageActivity()).createSubPbActivityConfig(cny, id, "pb", true, null, false, null, ckG, postData.crZ(), this.iZX.clB().getPbData().getAnti(), false, postData.aCo() != null ? postData.aCo().getIconInfo() : null).addBigImageData(FS.iEn, FS.iEo, FS.iEp, FS.index);
                addBigImageData.setKeyPageStartFrom(this.iZX.clB().coh());
                addBigImageData.setFromFrsForumId(this.iZX.clB().getFromForumId());
                addBigImageData.setKeyFromForumId(this.iZX.clB().getForumId());
                addBigImageData.setBjhData(this.iZX.clB().cnG());
                this.iZX.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    public PbActivity.a FS(String str) {
        String str2;
        if (this.iZX.clB() == null || this.iZX.clB().getPbData() == null || this.iZX.clB().getPbData().ckw() == null || this.iZX.clB().getPbData().ckw().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.iZX.clB().getPbData().ckw().size()) {
                i = 0;
                break;
            } else if (str.equals(this.iZX.clB().getPbData().ckw().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.iZX.clB().getPbData().ckw().get(i);
        if (postData.cLc() == null || postData.cLc().aTS() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.cLc().aTS().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.aTY() != null) {
                    str2 = next.aTY().aUl();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        f.a(postData, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bj(String str, int i) {
        TbRichText tbRichText = null;
        if (this.iZX.clB() == null || this.iZX.clB().getPbData() == null || str == null || i < 0) {
            return null;
        }
        e pbData = this.iZX.clB().getPbData();
        if (pbData.ckB() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.ckB());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> ckw = pbData.ckw();
            c(pbData, ckw);
            return c(ckw, str, i);
        }
        return tbRichText;
    }

    private void c(e eVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (eVar != null && eVar.ckF() != null && eVar.ckF().iCS != null && (list = eVar.ckF().iCS) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> aTS;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText cLc = arrayList.get(i2).cLc();
            if (cLc != null && (aTS = cLc.aTS()) != null) {
                int size = aTS.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (aTS.get(i4) != null && aTS.get(i4).getType() == 8) {
                        i3++;
                        if (aTS.get(i4).aTY().aUl().equals(str) || aTS.get(i4).aTY().aUm().equals(str)) {
                            int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = aTS.get(i4).aTY().getWidth() * equipmentDensity;
                            int height = aTS.get(i4).aTY().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.iIH = i4;
                            return cLc;
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
            e pbData = this.iZX.clB().getPbData();
            TbRichText bj = bj(str, i);
            if (bj != null && (tbRichTextData = bj.aTS().get(this.iIH)) != null) {
                aVar.postId = String.valueOf(bj.getPostId());
                aVar.iEn = new ArrayList<>();
                aVar.iEo = new ConcurrentHashMap<>();
                if (!tbRichTextData.aTY().aUj()) {
                    aVar.iEq = false;
                    String b = f.b(tbRichTextData);
                    aVar.iEn.add(b);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                        imageUrlData.urlType = 38;
                    } else {
                        imageUrlData.urlType = ((com.baidu.tieba.pb.videopb.e) y.b(this.iZX.cni()).l(com.baidu.tieba.pb.videopb.e.class)).isFromCDN() ? 17 : 18;
                    }
                    imageUrlData.originalUrl = c(tbRichTextData);
                    imageUrlData.originalUrl = c(tbRichTextData);
                    imageUrlData.originalSize = d(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                    imageUrlData.isLongPic = f(tbRichTextData);
                    imageUrlData.postId = bj.getPostId();
                    imageUrlData.mIsReserver = this.iZX.clB().cnP();
                    imageUrlData.mIsSeeHost = this.iZX.clB().getHostMode();
                    aVar.iEo.put(b, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.cku() != null) {
                            aVar.threadId = pbData.cku().getId();
                        }
                        aVar.iEp = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.iEq = true;
                int size = pbData.ckw().size();
                this.iII = false;
                aVar.index = -1;
                int a = pbData.ckB() != null ? a(pbData.ckB().cLc(), bj, i, i, aVar.iEn, aVar.iEo) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.ckw().get(i2);
                    if (postData.getId() == null || pbData.ckB() == null || pbData.ckB().getId() == null || !postData.getId().equals(pbData.ckB().getId())) {
                        a = a(postData.cLc(), bj, a, i, aVar.iEn, aVar.iEo);
                    }
                }
                if (aVar.iEn.size() > 0) {
                    aVar.lastId = aVar.iEn.get(aVar.iEn.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.cku() != null) {
                        aVar.threadId = pbData.cku().getId();
                    }
                    aVar.iEp = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a;
            }
        }
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo aTY;
        String str;
        if (tbRichText == tbRichText2) {
            this.iII = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.aTS().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.aTS().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.aTY().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.aTY().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.aTY().aUj()) {
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
                        String b = f.b(tbRichTextData);
                        if (!TextUtils.isEmpty(b)) {
                            arrayList.add(b);
                            if (tbRichTextData != null && (aTY = tbRichTextData.aTY()) != null) {
                                String aUl = aTY.aUl();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = aTY.aUm();
                                } else {
                                    imageUrlData.urlType = ((com.baidu.tieba.pb.videopb.e) y.b(this.iZX.cni()).l(com.baidu.tieba.pb.videopb.e.class)).isFromCDN() ? 17 : 18;
                                    str = aUl;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.iZX.clB().cny(), -1L);
                                imageUrlData.mIsReserver = this.iZX.clB().cnP();
                                imageUrlData.mIsSeeHost = this.iZX.clB().getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b, imageUrlData);
                                }
                            }
                        }
                        if (!this.iII) {
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

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aTY() == null) {
            return null;
        }
        return tbRichTextData.aTY().aUo();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aTY() == null) {
            return 0L;
        }
        return tbRichTextData.aTY().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aTY() == null) {
            return false;
        }
        return tbRichTextData.aTY().aUp();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aTY() == null) {
            return false;
        }
        return tbRichTextData.aTY().aUq();
    }

    public TbRichTextView.i getOnImageClickListener() {
        return this.dMx;
    }

    public com.baidu.tieba.pb.a.c ctx() {
        return this.dqK;
    }
}
