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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.d;
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
public class PostData implements com.baidu.adp.widget.ListView.h, af {
    private SkinInfo ajD;
    private String ajG;
    private OriginalThreadInfo akk;
    @Deprecated
    private String authorId;
    private TbRichTextVoiceInfo ayr;
    private String bimg_url;
    private SmallTailInfo fLL;
    private String fse;
    private boolean fts;
    public int gNC;
    public AlaLiveInfoCoreData gNH;
    private ArrayList<PostData> gNg;
    private com.baidu.tbadk.data.c gNn;
    private com.baidu.tbadk.data.f gNo;
    private h gNr;
    private az gNs;
    public boolean gNu;
    private com.baidu.tbadk.widget.richText.f gNv;
    private String gNw;
    private String gNx;
    private TPointPost gNy;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId gMV = BdUniqueId.gen();
    public static final BdUniqueId gMW = BdUniqueId.gen();
    public static final BdUniqueId ajE = BdUniqueId.gen();
    public static final BdUniqueId gMX = BdUniqueId.gen();
    public static final BdUniqueId aie = BdUniqueId.gen();
    public static final BdUniqueId gMY = BdUniqueId.gen();
    public static final BdUniqueId gMZ = BdUniqueId.gen();
    public static final BdUniqueId gNa = BdUniqueId.gen();
    public static boolean gNb = false;
    private int gNc = 0;
    private boolean gNh = false;
    private ArrayList<PostData> gNi = null;
    private TbRichText gNj = null;
    private boolean gNm = false;
    private boolean gNp = false;
    private boolean gNq = false;
    public boolean gNt = false;
    public int ajd = 0;
    private boolean gNz = false;
    private long agreeNum = 0;
    private boolean hasAgree = false;
    public boolean gNA = false;
    public boolean gNB = false;
    public boolean gND = false;
    public boolean gNE = true;
    public boolean gNF = false;
    public boolean gNG = false;
    private boolean gNI = false;
    private int gNJ = 0;
    private boolean gNK = true;
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData aiE = new MetaData();
    private ArrayList<k> gNd = new ArrayList<>();
    private ArrayList<k> gNe = new ArrayList<>();
    private int gNf = 0;
    private int ajn = 0;
    private PraiseData aiR = new PraiseData();
    private an gNk = new an();
    private c gNl = new c();
    private ArrayList<com.baidu.tbadk.data.c> ajA = new ArrayList<>();

    public PostData() {
        this.gNg = null;
        this.gNC = 0;
        this.gNg = new ArrayList<>();
        this.gNC = 0;
    }

    public void jG(boolean z) {
        this.fts = z;
    }

    public boolean bxu() {
        return this.fts;
    }

    public ArrayList<PostData> bxv() {
        return this.gNi;
    }

    public void bxw() {
        this.gNi.clear();
        this.gNi = null;
        this.gNh = false;
    }

    public void o(PostData postData) {
        if (postData != null) {
            if (this.gNi == null) {
                this.gNi = new ArrayList<>();
                if (w.z(this.gNg) > 2) {
                    this.gNi.addAll(w.a(this.gNg, 0, 2));
                } else {
                    this.gNi.addAll(this.gNg);
                }
            }
            this.gNi.add(postData);
        }
    }

    public void p(PostData postData) {
        if (postData != null && this.gNg != null) {
            this.gNg.add(postData);
            bxA();
        }
    }

    public void tM(String str) {
        if (this.gNi != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.gNi.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.gNi.remove(next);
                    return;
                }
            }
        }
    }

    public void mF(boolean z) {
        this.gNK = z;
    }

    public boolean bxx() {
        return this.gNK;
    }

    public void mG(boolean z) {
        this.gNh = z;
    }

    public boolean bxy() {
        return this.gNh;
    }

    public ArrayList<PostData> bxz() {
        return this.gNg;
    }

    public void bxA() {
        this.gNf++;
    }

    public void bxB() {
        this.gNf--;
    }

    public void tK(int i) {
        this.gNf = i;
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

    public void setTitle(String str) {
        this.title = str;
    }

    public String baO() {
        return this.fse;
    }

    public int bxC() {
        return this.floor_num;
    }

    public void tL(int i) {
        this.floor_num = i;
    }

    public boolean bxD() {
        return this.gNq;
    }

    public void mH(boolean z) {
        this.gNq = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = ap.w(j);
    }

    public MetaData vw() {
        return this.aiE;
    }

    public void a(MetaData metaData) {
        this.aiE = metaData;
    }

    public void a(PraiseData praiseData) {
        this.aiR = praiseData;
    }

    public TbRichText bxE() {
        return this.gNj;
    }

    public void c(TbRichText tbRichText) {
        this.gNj = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo bhG() {
        return this.fLL;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.fLL = smallTailInfo;
    }

    public com.baidu.tbadk.data.f bxF() {
        return this.gNo;
    }

    public SkinInfo vQ() {
        return this.ajD;
    }

    public void mI(boolean z) {
        this.gNI = z;
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.gNj != null && this.gNj.Nz() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.aiE != null && this.aiE.getIs_bawu() == 1) {
                    if (this.fts) {
                        str = " 品牌官";
                    } else if ("manager".equals(this.aiE.getBawu_type())) {
                        str = " 吧主";
                    } else if ("assist".equals(this.aiE.getBawu_type())) {
                        str = " 小吧主";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = vw().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.ig().a(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.f.c.ig().a(next.getIcon(), 21, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.f.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((C02371) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.na()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.gNj.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004005));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.h(aVar);
                        }
                    }, 0, 1);
                    cVar.d(0, 0, TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.e.ds32), TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.e.ds32));
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.aiE.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.aiE.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.aiE == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.aiE.getName_show() + str + "：");
                str2 = this.aiE.getUserName();
                str3 = this.aiE.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.aiE.getSealPrefix())) {
                Bitmap cR = am.cR(d.f.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cR);
                if (cR != null) {
                    bitmapDrawable.setBounds(0, 0, cR.getWidth(), cR.getHeight());
                }
                com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable);
                jVar.setOffset(com.baidu.adp.lib.util.l.e(tbPageContext.getPageActivity(), d.e.ds2));
                int size = arrayList.size() + this.aiE.getSealPrefix().length() + 1;
                spannableString.setSpan(jVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.aiE != null && this.aiE.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.b S = S(z, this.aiE != null && this.aiE.getIs_bawu() == 1);
                if (S != null) {
                    if (this.aiE != null) {
                        spannableString.setSpan(S, sb2.length() + this.aiE.getName_show().length() + 1, str.length() + sb2.length() + this.aiE.getName_show().length(), 17);
                    } else {
                        spannableString.setSpan(S, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> Nz = this.gNj.Nz();
            if (Nz != null && Nz.size() > 0) {
                TbRichTextData tbRichTextData2 = Nz.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.NG() != null) {
                    if (this.gNI) {
                        int indexOf = tbRichTextData2.NG().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.NG().delete(0, indexOf + 1);
                        }
                        this.gNI = false;
                    }
                    tbRichTextData2.fX(sb.length());
                    tbRichTextData2.NG().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= Nz.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (Nz.get(i4) == null || Nz.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        TbRichTextVoiceInfo NH = Nz.get(i4).NH();
                        Nz.remove(i4);
                        tbRichTextVoiceInfo = NH;
                        break;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.a(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.fX(sb.length());
                tbRichTextData.append(spannableString);
                Nz.add(0, tbRichTextData);
            }
        }
    }

    private com.baidu.tbadk.core.view.b S(boolean z, boolean z2) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        return new com.baidu.tbadk.core.view.b(com.baidu.adp.lib.util.l.e(context, d.e.tbds1), com.baidu.adp.lib.util.l.e(context, d.e.tbds4), this.fts ? d.C0142d.cp_link_tip_a_alpha50 : d.C0142d.cp_cont_j_alpha50, com.baidu.adp.lib.util.l.e(context, d.e.tbds30), this.fts ? d.C0142d.cp_link_tip_a : d.C0142d.cp_cont_j, com.baidu.adp.lib.util.l.e(context, d.e.tbds12), com.baidu.adp.lib.util.l.e(context, d.e.tbds42));
    }

    protected Drawable h(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap mZ;
        if (aVar == null || (mZ = aVar.mZ()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(mZ);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.e.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.e.ds36));
        return bitmapDrawable;
    }

    public int bxG() {
        return this.gNf;
    }

    public void cg(Context context) {
        int type;
        int i;
        int i2;
        if (this.gNd != null) {
            int i3 = -1;
            int size = this.gNe.size();
            if (size > 0) {
                try {
                    i3 = this.gNe.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.gNd.size()) {
                k kVar = this.gNd.get(i4);
                if (k.bJ(i5, kVar.getType())) {
                    this.gNe.get(size - 1).b(kVar.cf(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.gNe.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.cf(context));
                        this.gNe.add(kVar2);
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

    public void ch(Context context) {
        try {
            if (this.gNj != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.gNj.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.gNe == null || this.gNe.size() == 0) {
                cg(context);
            }
            ArrayList<k> arrayList = this.gNe;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.bxn() != null) {
                            sb.append((CharSequence) next.bxn());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(d.k.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(d.k.voice_str));
                    } else if (next.getType() == 2) {
                        String gG = TbFaceManager.IU().gG(next.getText());
                        if (gG != null) {
                            sb.append("[");
                            sb.append(gG);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !ap.isEmpty(next.bxm())) {
                        sb.append("[").append(next.bxm()).append("]");
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
                this.floor_num = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = ap.w(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.gNp = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aiE = metaData;
                }
                if ((this.aiE.getUserId() == null || this.aiE.getUserId().length() <= 0 || this.aiE.getUserId().equals("0")) && metaData2 != null) {
                    this.aiE = metaData2;
                }
                this.gNj = TbRichTextView.a(context, subPostList.content, z);
                if (this.gNj != null) {
                    this.gNj.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
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
                this.title = post.title;
                this.floor_num = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = ap.w(this.time);
                this.fse = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aiE = metaData;
                }
                this.gNA = post.need_log.intValue() == 1;
                this.gNB = post.img_num_abtest.intValue() == 1;
                this.gNs = new az();
                this.gNs.parserProtobuf(post.from_forum);
                if (this.aiE.getUserId() == null || this.aiE.getUserId().length() <= 0 || this.aiE.getUserId().equals("0")) {
                    this.aiE.parserProtobuf(post.author);
                }
                if (this.aiE != null && context != null) {
                    this.gNw = this.aiE.getUserName() + context.getResources().getString(d.k.somebodys_portrait);
                    this.gNx = String.format(TbadkCoreApplication.getInst().getString(d.k.degree_in_forum), Integer.valueOf(this.aiE.getLevel_id()));
                }
                this.gNm = post.is_ntitle.intValue() == 1;
                this.gNf = post.sub_post_number.intValue();
                this.gNr = new h(post.tpoint_post);
                this.gNj = TbRichTextView.a(context, post.content, true);
                if (this.gNj != null) {
                    this.gNj.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.gNj.fW(this.floor_num);
                    if (this.aiE != null) {
                        this.gNj.setAuthorId(this.aiE.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.gNp = subPostList.is_giftpost.intValue() == 1;
                            postData.setUserMap(this.userMap);
                            postData.jG(this.fts);
                            postData.a(subPostList, context);
                            this.gNg.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.gNl.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.gNn = new com.baidu.tbadk.data.c();
                    this.gNn.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.gNo = new com.baidu.tbadk.data.f();
                    this.gNo.a(post.lbs_info);
                }
                this.ajn = post.storecount.intValue();
                this.gNk.a(post.present);
                this.aiR.setUserMap(this.userMap);
                this.aiR.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.fLL = new SmallTailInfo();
                    this.fLL.id = post.signature.signature_id.intValue();
                    this.fLL.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.fLL.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.fLL.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.fLL.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.ajA.add(cVar);
                    }
                }
                this.ajD = post.skin_info;
                this.ajG = post.lego_card;
                this.gNy = post.tpoint_post;
                if (post.agree != null) {
                    this.gNz = true;
                    this.hasAgree = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.agreeNum = post.agree.agree_num.longValue();
                    } else {
                        this.agreeNum = 0L;
                    }
                } else {
                    this.gNz = false;
                }
                this.gNG = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.akk = new OriginalThreadInfo();
                    this.akk.parser(post.origin_thread_info);
                } else {
                    this.akk = null;
                }
                this.gNJ = post.is_fold.intValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int fJV;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(this.fJV));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> gNQ;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.gNQ = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(d.C0142d.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.gNQ != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.gNQ.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String ci(Context context) {
        ArrayList<TbRichTextData> Nz;
        if (this.gNj == null || (Nz = this.gNj.Nz()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = Nz.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.NG().toString());
            } else if (next.getType() == 17) {
                String str = next.NK().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(d.k.editor_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(d.k.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(d.k.video_title_str) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public String bxH() {
        ArrayList<TbRichTextData> Nz;
        String str;
        if (this.gNj == null || (Nz = this.gNj.Nz()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = Nz.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.NG().toString());
                } else if (next.getType() == 17) {
                    if (next.NK() != null && next.NK().mGifInfo != null && (str = next.NK().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo bxI() {
        ArrayList<TbRichTextData> Nz;
        if (this.gNj != null && (Nz = this.gNj.Nz()) != null) {
            Iterator<TbRichTextData> it = Nz.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.NF().getWidth();
                    preLoadImageInfo.height = next.NF().getHeight();
                    preLoadImageInfo.imgUrl = next.NF().NS();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.NL().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.NL().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.NL().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String bxJ() {
        j bxf;
        PreLoadImageInfo bxI = bxI();
        if (bxI != null && !StringUtils.isNull(bxI.imgUrl)) {
            return bxI.imgUrl;
        }
        if (this.gNr != null && (bxf = this.gNr.bxf()) != null && !StringUtils.isNull(bxf.bxk())) {
            return bxf.bxk();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.af
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> Nz;
        if (this.gNj == null || (Nz = this.gNj.Nz()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = Nz.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.NF().getWidth();
                preLoadImageInfo.height = next.NF().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.NF().NX()) {
                    preLoadImageInfo.imgUrl = next.NF().NT();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.NF().NS();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.NK() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.NK().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.NK().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.NK();
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
        if (this.aiE == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.aiE.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.gNc == 52) {
            return gMZ;
        }
        if (this.gNc == 1) {
            return ajE;
        }
        if (this.gNc == 36) {
            return gMX;
        }
        if (this.gNc == 40 || this.gNc == 50) {
            return aie;
        }
        if (this.gNc == 41) {
            return gMY;
        }
        if (this.gNc == 53) {
            return gNa;
        }
        if (bxC() == 1) {
            return gMV;
        }
        return gMW;
    }

    public void setPostType(int i) {
        this.gNc = i;
    }

    public an bxK() {
        return this.gNk;
    }

    public void a(an anVar) {
        this.gNk = anVar;
    }

    public h bxL() {
        return this.gNr;
    }

    public com.baidu.tbadk.widget.richText.f NJ() {
        if (this.gNv != null) {
            return this.gNv;
        }
        if (this.gNj != null && w.z(this.gNj.Nz()) > 0) {
            Iterator<TbRichTextData> it = this.gNj.Nz().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.gNv = next.NJ();
                    return this.gNv;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo NH() {
        if (this.ayr != null) {
            return this.ayr;
        }
        if (this.gNj != null && w.z(this.gNj.Nz()) > 0) {
            Iterator<TbRichTextData> it = this.gNj.Nz().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.ayr = next.NH();
                    return this.ayr;
                }
            }
        }
        return null;
    }

    public String bxM() {
        return this.gNw;
    }

    public String wn() {
        return this.ajG;
    }

    public void wq() {
        if (this.ajd == 0) {
            this.ajd = 1;
        }
    }

    public long bxN() {
        return this.agreeNum;
    }

    public void cV(long j) {
        this.agreeNum = j;
    }

    public boolean bxO() {
        return this.hasAgree;
    }

    public void mJ(boolean z) {
        this.hasAgree = z;
    }

    public OriginalThreadInfo bxP() {
        return this.akk;
    }

    public void g(OriginalThreadInfo originalThreadInfo) {
        this.akk = originalThreadInfo;
    }

    public int bxQ() {
        return this.gNJ;
    }
}
