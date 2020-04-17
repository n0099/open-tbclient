package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.c;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes.dex */
public class PostData implements com.baidu.adp.widget.ListView.m, ae {
    @Deprecated
    private String authorId;
    private String bimg_url;
    private TbRichTextVoiceInfo dIL;
    private SkinInfo dsI;
    private String dsL;
    private OriginalThreadInfo dto;
    private SmallTailInfo jIi;
    private String joa;
    private ArrayList<PostData> kSC;
    private com.baidu.tbadk.data.c kSJ;
    private com.baidu.tbadk.data.f kSK;
    private i kSN;
    private bf kSO;
    public boolean kSQ;
    private com.baidu.tbadk.widget.richText.i kSR;
    private String kSS;
    private String kST;
    private TPointPost kSU;
    public int kSX;
    private String kSy;
    public boolean kTa;
    public AlaLiveInfoCoreData kTd;
    private boolean kTh;
    private boolean kTk;
    public an kTm;
    public int locate;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId kSn = BdUniqueId.gen();
    public static final BdUniqueId kSo = BdUniqueId.gen();
    public static final BdUniqueId dsJ = BdUniqueId.gen();
    public static final BdUniqueId kSp = BdUniqueId.gen();
    public static final BdUniqueId dqV = BdUniqueId.gen();
    public static final BdUniqueId kSq = BdUniqueId.gen();
    public static final BdUniqueId kSr = BdUniqueId.gen();
    public static final BdUniqueId kSs = BdUniqueId.gen();
    public static final BdUniqueId kSt = BdUniqueId.gen();
    public static final BdUniqueId kSu = BdUniqueId.gen();
    public static boolean kSv = false;
    private int kSw = 0;
    private boolean kSD = false;
    private ArrayList<PostData> kSE = null;
    private TbRichText kSF = null;
    private boolean kSI = false;
    private boolean kSL = false;
    private boolean kSM = false;
    public boolean kSP = false;
    public int dsh = 0;
    private boolean kSV = false;
    public boolean hfJ = false;
    public boolean kSW = false;
    public boolean kSY = false;
    public boolean kSZ = true;
    public boolean kTb = false;
    public boolean kTc = false;
    private boolean kTe = false;
    private int kTf = 0;
    private boolean kTg = true;
    public boolean kTi = false;
    public boolean kTj = false;
    public boolean kTl = false;
    private b kTn = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.kTm != null) {
                an aOQ = PostData.this.kTm.aOQ();
                aOQ.delete("obj_locate");
                aOQ.af("obj_locate", 7);
                TiebaStatic.log(aOQ);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int kSx = 0;
    private long time = 0;
    private String date = null;
    private MetaData drK = new MetaData();
    private ArrayList<l> kSz = new ArrayList<>();
    private ArrayList<l> kSA = new ArrayList<>();
    private int kSB = 0;
    private int dss = 0;
    private PraiseData drV = new PraiseData();
    private ar kSG = new ar();
    private c kSH = new c();
    private ArrayList<com.baidu.tbadk.data.c> dsF = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.kSC = null;
        this.kSX = 0;
        this.kSC = new ArrayList<>();
        this.kSX = 0;
    }

    public void tS(boolean z) {
        this.kTh = z;
    }

    public boolean cWj() {
        return this.kTh;
    }

    public ArrayList<PostData> cWk() {
        return this.kSE;
    }

    public void cWl() {
        this.kSE.clear();
        this.kSE = null;
        this.kSD = false;
    }

    public void t(PostData postData) {
        if (postData != null) {
            if (this.kSE == null) {
                this.kSE = new ArrayList<>();
                if (v.getCount(this.kSC) > 2) {
                    this.kSE.addAll(v.subList(this.kSC, 0, 2));
                } else {
                    this.kSE.addAll(this.kSC);
                }
            }
            this.kSE.add(postData);
        }
    }

    public void u(PostData postData) {
        if (postData != null && this.kSC != null) {
            this.kSC.add(postData);
            cWp();
        }
    }

    public void KL(String str) {
        if (this.kSE != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.kSE.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.kSE.remove(next);
                    return;
                }
            }
        }
    }

    public void tT(boolean z) {
        this.kTg = z;
    }

    public boolean cWm() {
        return this.kTg;
    }

    public void tU(boolean z) {
        this.kSD = z;
    }

    public boolean cWn() {
        return this.kSD;
    }

    public ArrayList<PostData> cWo() {
        return this.kSC;
    }

    public void cWp() {
        this.kSB++;
    }

    public void cWq() {
        this.kSB--;
    }

    public void Dh(int i) {
        this.kSB = i;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public long getTid() {
        return this.tid;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int cWr() {
        return this.kSx;
    }

    public void Di(int i) {
        this.kSx = i;
    }

    public boolean cWs() {
        return this.kSM;
    }

    public void tV(boolean z) {
        this.kSM = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = aq.getFormatTime(j);
    }

    public MetaData aKE() {
        return this.drK;
    }

    public void a(MetaData metaData) {
        this.drK = metaData;
    }

    public void a(PraiseData praiseData) {
        this.drV = praiseData;
    }

    public TbRichText cWt() {
        return this.kSF;
    }

    public void c(TbRichText tbRichText) {
        this.kSF = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo cDb() {
        return this.jIi;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.jIi = smallTailInfo;
    }

    public com.baidu.tbadk.data.f cWu() {
        return this.kSK;
    }

    public SkinInfo aKZ() {
        return this.dsI;
    }

    public void tW(boolean z) {
        this.kTe = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.kSF != null && this.kSF.bch() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.drK != null && this.drK.getIs_bawu() == 1) {
                    if (this.kTh) {
                        str = " 品牌官";
                    } else if (Config.BAWU_TYPE_MANAGER.equals(this.drK.getBawu_type())) {
                        str = " 吧主";
                    } else if (Config.BAWU_TYPE_ASSIST.equals(this.drK.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.drK.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.drK.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = aKE().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.c.kV().loadResourceFromMemery(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.e.c.kV().a(next.getIcon(), 21, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.e.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((AnonymousClass1) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.isValidNow()) {
                                            cVar2.setDrawable(PostData.this.j(aVar2));
                                            PostData.this.kSF.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.j(aVar);
                        }
                    }, 0, 1);
                    cVar.setEmptyBounds(0, 0, TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds32), TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds32));
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.drK.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.drK.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.drK == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.drK.getName_show() + str + "：");
                str2 = this.drK.getUserName();
                str3 = this.drK.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.drK.getSealPrefix())) {
                Bitmap bitmap = am.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable);
                jVar.setOffset(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.drK.getSealPrefix().length() + 1;
                spannableString.setSpan(jVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.kTn), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.drK != null && this.drK.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.b e = e(z, this.drK != null && this.drK.getIs_bawu() == 1, str);
                if (e != null) {
                    if (this.drK != null) {
                        int i3 = 0;
                        if (this.drK.getName_show() != null) {
                            i3 = this.drK.getName_show().length();
                        }
                        spannableString.setSpan(e, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(e, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> bch = this.kSF.bch();
            if (bch != null && bch.size() > 0) {
                TbRichTextData tbRichTextData2 = bch.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.bco() != null) {
                    if (this.kTe) {
                        int indexOf = tbRichTextData2.bco().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.bco().delete(0, indexOf + 1);
                        }
                        this.kTe = false;
                    }
                    tbRichTextData2.nH(sb.length());
                    tbRichTextData2.bco().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= bch.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (bch.get(i5) == null || bch.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo bcp = bch.get(i5).bcp();
                            bch.remove(i5);
                            tbRichTextVoiceInfo = bcp;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.nH(sb.length());
                    tbRichTextData.j(spannableString);
                    bch.add(0, tbRichTextData);
                }
            }
            this.kTi = true;
        }
    }

    private com.baidu.tbadk.core.view.b e(boolean z, boolean z2, String str) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        com.baidu.tbadk.core.view.b bVar = new com.baidu.tbadk.core.view.b(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds5), R.color.cp_link_tip_a, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26), R.color.cp_bg_line_d, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds12), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds40));
        bVar.gN(true);
        if (" 吧主".equals(str) || " 小吧主".equals(str) || " 楼主".equals(str) || " 品牌官".equals(str)) {
            bVar.lf(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds6));
            bVar.vf(str);
            return bVar;
        }
        return bVar;
    }

    protected Drawable j(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (aVar == null || (rawBitmap = aVar.getRawBitmap()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(rawBitmap);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.ds36));
        return bitmapDrawable;
    }

    public int cWv() {
        return this.kSB;
    }

    public void fl(Context context) {
        int type;
        int i;
        int i2;
        if (this.kSz != null) {
            int i3 = -1;
            int size = this.kSA.size();
            if (size > 0) {
                try {
                    i3 = this.kSA.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.kSz.size()) {
                l lVar = this.kSz.get(i4);
                if (l.cQ(i5, lVar.getType())) {
                    this.kSA.get(size - 1).b(lVar.fk(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.kSA.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.fk(context));
                        this.kSA.add(lVar2);
                        type = 0;
                    }
                    i = type;
                    i2 = size + 1;
                }
                i4++;
                i5 = i;
                size = i2;
            }
        }
    }

    public void fm(Context context) {
        try {
            if (this.kSF != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.kSF.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.kSA == null || this.kSA.size() == 0) {
                fl(context);
            }
            ArrayList<l> arrayList = this.kSA;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.cWc() != null) {
                            sb.append((CharSequence) next.cWc());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String wr = TbFaceManager.aYl().wr(next.getText());
                        if (wr != null) {
                            sb.append("[");
                            sb.append(wr);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !aq.isEmpty(next.cWb())) {
                        sb.append("[").append(next.cWb()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                if (clipboardManager2.getText() != null) {
                }
            }
        } catch (NullPointerException e) {
            BdLog.detailException(e);
        }
    }

    public void a(SubPostList subPostList, Context context) {
        a(subPostList, context, false);
    }

    public void a(SubPostList subPostList, Context context, boolean z) {
        MetaData metaData;
        if (subPostList != null) {
            try {
                this.id = String.valueOf(subPostList.id);
                this.title = subPostList.title;
                this.kSx = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = aq.getFormatTime(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.kSL = subPostList.is_giftpost.intValue() == 1;
                this.agreeData.postId = this.id;
                this.agreeData.parseProtobuf(subPostList.agree);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.drK = metaData;
                }
                if (this.drK.getUserId() == null || this.drK.getUserId().length() <= 0 || this.drK.getUserId().equals("0")) {
                    this.drK = metaData2;
                }
                this.kSF = TbRichTextView.a(context, subPostList.content, z);
                if (this.kSF != null) {
                    this.kSF.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Post post, Context context) {
        MetaData metaData;
        if (post != null) {
            try {
                this.id = String.valueOf(post.id);
                this.tid = post.tid.longValue();
                this.title = post.title;
                this.kSx = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = aq.getFormatTime(this.time);
                this.kSy = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.drK = metaData;
                }
                this.hfJ = post.need_log.intValue() == 1;
                this.kSW = post.img_num_abtest.intValue() == 1;
                this.kSO = new bf();
                this.kSO.parserProtobuf(post.from_forum);
                if (this.drK.getUserId() == null || this.drK.getUserId().length() <= 0 || this.drK.getUserId().equals("0")) {
                    this.drK.parserProtobuf(post.author);
                }
                if (this.drK != null && context != null) {
                    this.kSS = this.drK.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.kST = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.drK.getLevel_id()));
                }
                this.kSI = post.is_ntitle.intValue() == 1;
                this.kSB = post.sub_post_number.intValue();
                this.kSN = new i(post.tpoint_post);
                this.kSF = TbRichTextView.a(context, post.content, true);
                if (this.kSF != null) {
                    this.kSF.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                    this.kSF.nG(this.kSx);
                    if (this.drK != null) {
                        this.kSF.setAuthorId(this.drK.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.kSL = subPostList.is_giftpost.intValue() == 1;
                            postData.agreeData.parseProtobuf(subPostList.agree);
                            postData.setUserMap(this.userMap);
                            postData.tS(this.kTh);
                            postData.a(subPostList, context);
                            this.kSC.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.kSH.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.kSJ = new com.baidu.tbadk.data.c();
                    this.kSJ.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.kSK = new com.baidu.tbadk.data.f();
                    this.kSK.a(post.lbs_info);
                }
                this.dss = post.storecount.intValue();
                this.kSG.a(post.present);
                this.drV.setUserMap(this.userMap);
                this.drV.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.jIi = new SmallTailInfo();
                    this.jIi.id = post.signature.signature_id.intValue();
                    this.jIi.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.jIi.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.jIi.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.jIi.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.dsF.add(cVar);
                    }
                }
                this.dsI = post.skin_info;
                this.dsL = post.lego_card;
                this.kSU = post.tpoint_post;
                if (post.agree != null) {
                    this.kSV = true;
                    this.agreeData.postId = this.id;
                    this.agreeData.parseProtobuf(post.agree);
                } else {
                    this.kSV = false;
                }
                this.kTc = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.dto = new OriginalThreadInfo();
                    this.dto.a(post.origin_thread_info);
                } else {
                    this.dto = null;
                }
                this.kTf = post.is_fold.intValue();
                this.joa = post.fold_tip;
                this.kTj = post.is_top_agree_post.intValue() == 1;
                this.kTk = post.show_squared.intValue() == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int mColorId;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(this.mColorId));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> kTt;
        private b kTu;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.kTt = new SoftReference<>(context);
            this.kTu = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(R.color.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.kTt != null && this.kTt.get() != null) {
                if (this.kTu != null) {
                    this.kTu.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.kTt.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String fn(Context context) {
        ArrayList<TbRichTextData> bch;
        if (this.kSF == null || (bch = this.kSF.bch()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = bch.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.bco().toString());
            } else if (next.getType() == 17) {
                String str = next.bcs().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(R.string.editor_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(R.string.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(R.string.video_title_str) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public String cWw() {
        ArrayList<TbRichTextData> bch;
        String str;
        if (this.kSF == null || (bch = this.kSF.bch()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = bch.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.bco().toString());
                } else if (next.getType() == 17) {
                    if (next.bcs() != null && next.bcs().mGifInfo != null && (str = next.bcs().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo cWx() {
        ArrayList<TbRichTextData> bch;
        if (this.kSF != null && (bch = this.kSF.bch()) != null) {
            Iterator<TbRichTextData> it = bch.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.bcn().getWidth();
                    preLoadImageInfo.height = next.bcn().getHeight();
                    preLoadImageInfo.imgUrl = next.bcn().bcA();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.bct().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.bct().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.bct().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String cWy() {
        k cVZ;
        PreLoadImageInfo cWx = cWx();
        if (cWx != null && !StringUtils.isNull(cWx.imgUrl)) {
            return cWx.imgUrl;
        }
        if (this.kSN != null && (cVZ = this.kSN.cVZ()) != null && !StringUtils.isNull(cVZ.cWa())) {
            return cVZ.cWa();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> bch;
        if (this.kSF == null || (bch = this.kSF.bch()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = bch.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.bcn().getWidth();
                preLoadImageInfo.height = next.bcn().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.bcn().bcF()) {
                    preLoadImageInfo.imgUrl = next.bcn().bcB();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.bcn().bcA();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.bcs() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.bcs().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.bcs().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.bcs();
                preLoadImageInfo2.procType = 20;
                arrayList.add(preLoadImageInfo2);
            }
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.bimg_url;
            preLoadImageInfo3.width = 105;
            preLoadImageInfo3.width = 105;
            preLoadImageInfo3.procType = 19;
            arrayList.add(preLoadImageInfo3);
        }
        if (this.drK == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.drK.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.kSw == 52) {
            return kSs;
        }
        if (this.kSw == 1) {
            return dsJ;
        }
        if (this.kSw == 36) {
            return kSp;
        }
        if (this.kSw == 40 || this.kSw == 50) {
            return dqV;
        }
        if (this.kSw == 41) {
            return kSq;
        }
        if (this.kSw == 53) {
            return kSt;
        }
        if (cWr() == 1) {
            return kSn;
        }
        return kSo;
    }

    public void setPostType(int i) {
        this.kSw = i;
    }

    public ar cWz() {
        return this.kSG;
    }

    public void a(ar arVar) {
        this.kSG = arVar;
    }

    public i cWA() {
        return this.kSN;
    }

    public com.baidu.tbadk.widget.richText.i bcr() {
        if (this.kSR != null) {
            return this.kSR;
        }
        if (this.kSF != null && v.getCount(this.kSF.bch()) > 0) {
            Iterator<TbRichTextData> it = this.kSF.bch().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.kSR = next.bcr();
                    return this.kSR;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo bcp() {
        if (this.dIL != null) {
            return this.dIL;
        }
        if (this.kSF != null && v.getCount(this.kSF.bch()) > 0) {
            Iterator<TbRichTextData> it = this.kSF.bch().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.dIL = next.bcp();
                    return this.dIL;
                }
            }
        }
        return null;
    }

    public String cWB() {
        return this.kSS;
    }

    public String aLL() {
        return this.dsL;
    }

    public void aLN() {
        if (this.dsh == 0) {
            this.dsh = 1;
        }
    }

    public long aMa() {
        return this.agreeData.disAgreeNum;
    }

    public AgreeData aMs() {
        return this.agreeData;
    }

    public OriginalThreadInfo cWC() {
        return this.dto;
    }

    public void h(OriginalThreadInfo originalThreadInfo) {
        this.dto = originalThreadInfo;
    }

    public int cWD() {
        return this.kTf;
    }

    public String cvC() {
        return this.joa;
    }

    public boolean cWE() {
        return this.kTk;
    }
}
