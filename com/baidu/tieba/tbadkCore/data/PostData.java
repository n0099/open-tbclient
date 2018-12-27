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
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.e;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.Agree;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes.dex */
public class PostData implements com.baidu.adp.widget.ListView.h, ae {
    private TbRichTextVoiceInfo aJX;
    private Agree agree;
    private SkinInfo auK;
    private String auN;
    @Deprecated
    private String authorId;
    private long avi;
    private int avk;
    private OriginalThreadInfo avt;
    private String bimg_url;
    private String fSC;
    private boolean fTO;
    private String fTo;
    private SmallTailInfo gmg;
    private ArrayList<PostData> hoJ;
    private com.baidu.tbadk.data.c hoQ;
    private com.baidu.tbadk.data.f hoR;
    private h hoU;
    private ay hoV;
    public boolean hoX;
    private com.baidu.tbadk.widget.richText.f hoY;
    private String hoZ;
    private String hpa;
    private TPointPost hpb;
    public int hpe;
    public AlaLiveInfoCoreData hpj;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId hox = BdUniqueId.gen();
    public static final BdUniqueId hoy = BdUniqueId.gen();
    public static final BdUniqueId auL = BdUniqueId.gen();
    public static final BdUniqueId hoz = BdUniqueId.gen();
    public static final BdUniqueId atj = BdUniqueId.gen();
    public static final BdUniqueId hoA = BdUniqueId.gen();
    public static final BdUniqueId hoB = BdUniqueId.gen();
    public static final BdUniqueId hoC = BdUniqueId.gen();
    public static final BdUniqueId hoD = BdUniqueId.gen();
    public static boolean hoE = false;
    private int hoF = 0;
    private boolean hoK = false;
    private ArrayList<PostData> hoL = null;
    private TbRichText hoM = null;
    private boolean hoP = false;
    private boolean hoS = false;
    private boolean hoT = false;
    public boolean hoW = false;
    public int auk = 0;
    private boolean hpc = false;
    private long agreeNum = 0;
    private boolean hasAgree = false;
    public boolean dRB = false;
    public boolean hpd = false;
    public boolean hpf = false;
    public boolean hpg = true;
    public boolean hph = false;
    public boolean hpi = false;
    private boolean hpk = false;
    private int hpl = 0;
    private boolean hpm = true;
    public boolean hpn = false;
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData atK = new MetaData();
    private ArrayList<k> hoG = new ArrayList<>();
    private ArrayList<k> hoH = new ArrayList<>();
    private int hoI = 0;
    private int auu = 0;
    private PraiseData atX = new PraiseData();
    private am hoN = new am();
    private c hoO = new c();
    private ArrayList<com.baidu.tbadk.data.c> auH = new ArrayList<>();

    public PostData() {
        this.hoJ = null;
        this.hpe = 0;
        this.hoJ = new ArrayList<>();
        this.hpe = 0;
    }

    public void kA(boolean z) {
        this.fTO = z;
    }

    public boolean bEb() {
        return this.fTO;
    }

    public ArrayList<PostData> bEc() {
        return this.hoL;
    }

    public void bEd() {
        this.hoL.clear();
        this.hoL = null;
        this.hoK = false;
    }

    public void p(PostData postData) {
        if (postData != null) {
            if (this.hoL == null) {
                this.hoL = new ArrayList<>();
                if (v.H(this.hoJ) > 2) {
                    this.hoL.addAll(v.b(this.hoJ, 0, 2));
                } else {
                    this.hoL.addAll(this.hoJ);
                }
            }
            this.hoL.add(postData);
        }
    }

    public void q(PostData postData) {
        if (postData != null && this.hoJ != null) {
            this.hoJ.add(postData);
            bEh();
        }
    }

    public void vG(String str) {
        if (this.hoL != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.hoL.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.hoL.remove(next);
                    return;
                }
            }
        }
    }

    public void nu(boolean z) {
        this.hpm = z;
    }

    public boolean bEe() {
        return this.hpm;
    }

    public void nv(boolean z) {
        this.hoK = z;
    }

    public boolean bEf() {
        return this.hoK;
    }

    public ArrayList<PostData> bEg() {
        return this.hoJ;
    }

    public void bEh() {
        this.hoI++;
    }

    public void bEi() {
        this.hoI--;
    }

    public void vH(int i) {
        this.hoI = i;
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

    public String bgO() {
        return this.fSC;
    }

    public int bEj() {
        return this.floor_num;
    }

    public void vI(int i) {
        this.floor_num = i;
    }

    public boolean bEk() {
        return this.hoT;
    }

    public void nw(boolean z) {
        this.hoT = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = ao.M(j);
    }

    public MetaData zG() {
        return this.atK;
    }

    public void a(MetaData metaData) {
        this.atK = metaData;
    }

    public void a(PraiseData praiseData) {
        this.atX = praiseData;
    }

    public TbRichText bEl() {
        return this.hoM;
    }

    public void c(TbRichText tbRichText) {
        this.hoM = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo bnJ() {
        return this.gmg;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.gmg = smallTailInfo;
    }

    public com.baidu.tbadk.data.f bEm() {
        return this.hoR;
    }

    public SkinInfo Ac() {
        return this.auK;
    }

    public void nx(boolean z) {
        this.hpk = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.hoM != null && this.hoM.Sb() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.atK != null && this.atK.getIs_bawu() == 1) {
                    if (this.fTO) {
                        str = " 品牌官";
                    } else if ("manager".equals(this.atK.getBawu_type())) {
                        str = " 吧主";
                    } else if ("assist".equals(this.atK.getBawu_type())) {
                        str = " 小吧主";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = zG().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.jA().a(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.f.c.jA().a(next.getIcon(), 21, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.f.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((C03171) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.oq()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.hoM.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004005));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.h(aVar);
                        }
                    }, 0, 1);
                    cVar.d(0, 0, TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(e.C0210e.ds32), TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(e.C0210e.ds32));
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.atK.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.atK.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.atK == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.atK.getName_show() + str + "：");
                str2 = this.atK.getUserName();
                str3 = this.atK.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.atK.getSealPrefix())) {
                Bitmap dO = al.dO(e.f.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(dO);
                if (dO != null) {
                    bitmapDrawable.setBounds(0, 0, dO.getWidth(), dO.getHeight());
                }
                com.baidu.tbadk.core.view.m mVar = new com.baidu.tbadk.core.view.m(bitmapDrawable);
                mVar.setOffset(com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), e.C0210e.ds2));
                int size = arrayList.size() + this.atK.getSealPrefix().length() + 1;
                spannableString.setSpan(mVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.atK != null && this.atK.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.e X = X(z, this.atK != null && this.atK.getIs_bawu() == 1);
                if (X != null) {
                    if (this.atK != null) {
                        int i3 = 0;
                        if (this.atK.getName_show() != null) {
                            i3 = this.atK.getName_show().length();
                        }
                        spannableString.setSpan(X, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(X, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> Sb = this.hoM.Sb();
            if (Sb != null && Sb.size() > 0) {
                TbRichTextData tbRichTextData2 = Sb.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.Si() != null) {
                    if (this.hpk) {
                        int indexOf = tbRichTextData2.Si().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.Si().delete(0, indexOf + 1);
                        }
                        this.hpk = false;
                    }
                    tbRichTextData2.gV(sb.length());
                    tbRichTextData2.Si().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= Sb.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (Sb.get(i5) == null || Sb.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo Sj = Sb.get(i5).Sj();
                            Sb.remove(i5);
                            tbRichTextVoiceInfo = Sj;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.gV(sb.length());
                    tbRichTextData.append(spannableString);
                    Sb.add(0, tbRichTextData);
                }
            }
            this.hpn = true;
        }
    }

    private com.baidu.tbadk.core.view.e X(boolean z, boolean z2) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        return new com.baidu.tbadk.core.view.e(com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds1), com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds4), this.fTO ? e.d.cp_link_tip_a_alpha50 : e.d.cp_cont_j_alpha50, com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds30), this.fTO ? e.d.cp_link_tip_a : e.d.cp_cont_j, com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds12), com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds42));
    }

    protected Drawable h(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap op;
        if (aVar == null || (op = aVar.op()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(op);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(e.C0210e.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(e.C0210e.ds36));
        return bitmapDrawable;
    }

    public int bEn() {
        return this.hoI;
    }

    public void cY(Context context) {
        int type;
        int i;
        int i2;
        if (this.hoG != null) {
            int i3 = -1;
            int size = this.hoH.size();
            if (size > 0) {
                try {
                    i3 = this.hoH.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.hoG.size()) {
                k kVar = this.hoG.get(i4);
                if (k.bS(i5, kVar.getType())) {
                    this.hoH.get(size - 1).b(kVar.cX(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.hoH.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.cX(context));
                        this.hoH.add(kVar2);
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

    public void cZ(Context context) {
        try {
            if (this.hoM != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.hoM.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.hoH == null || this.hoH.size() == 0) {
                cY(context);
            }
            ArrayList<k> arrayList = this.hoH;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.bDU() != null) {
                            sb.append((CharSequence) next.bDU());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(e.j.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(e.j.voice_str));
                    } else if (next.getType() == 2) {
                        String hG = TbFaceManager.Nu().hG(next.getText());
                        if (hG != null) {
                            sb.append("[");
                            sb.append(hG);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !ao.isEmpty(next.bDT())) {
                        sb.append("[").append(next.bDT()).append("]");
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
                this.date = ao.M(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.hoS = subPostList.is_giftpost.intValue() == 1;
                this.agree = subPostList.agree;
                if (this.agree != null) {
                    this.avk = this.agree.agree_type.intValue();
                    this.hasAgree = this.agree.has_agree.intValue() == 1;
                    this.agreeNum = this.agree.agree_num.longValue() > 0 ? this.agree.agree_num.longValue() : 0L;
                    this.avi = this.agree.disagree_num.longValue() > 0 ? this.agree.disagree_num.longValue() : 0L;
                }
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.atK = metaData;
                }
                if ((this.atK.getUserId() == null || this.atK.getUserId().length() <= 0 || this.atK.getUserId().equals("0")) && metaData2 != null) {
                    this.atK = metaData2;
                }
                this.hoM = TbRichTextView.a(context, subPostList.content, z);
                if (this.hoM != null) {
                    this.hoM.setPostId(com.baidu.adp.lib.g.b.d(this.id, -1L));
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
                this.date = ao.M(this.time);
                this.fSC = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.atK = metaData;
                }
                this.dRB = post.need_log.intValue() == 1;
                this.hpd = post.img_num_abtest.intValue() == 1;
                this.hoV = new ay();
                this.hoV.parserProtobuf(post.from_forum);
                if (this.atK.getUserId() == null || this.atK.getUserId().length() <= 0 || this.atK.getUserId().equals("0")) {
                    this.atK.parserProtobuf(post.author);
                }
                if (this.atK != null && context != null) {
                    this.hoZ = this.atK.getUserName() + context.getResources().getString(e.j.somebodys_portrait);
                    this.hpa = String.format(TbadkCoreApplication.getInst().getString(e.j.degree_in_forum), Integer.valueOf(this.atK.getLevel_id()));
                }
                this.hoP = post.is_ntitle.intValue() == 1;
                this.hoI = post.sub_post_number.intValue();
                this.hoU = new h(post.tpoint_post);
                this.hoM = TbRichTextView.a(context, post.content, true);
                if (this.hoM != null) {
                    this.hoM.setPostId(com.baidu.adp.lib.g.b.d(this.id, -1L));
                    this.hoM.gU(this.floor_num);
                    if (this.atK != null) {
                        this.hoM.setAuthorId(this.atK.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.hoS = subPostList.is_giftpost.intValue() == 1;
                            postData.agree = subPostList.agree;
                            postData.setUserMap(this.userMap);
                            postData.kA(this.fTO);
                            postData.a(subPostList, context);
                            this.hoJ.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.hoO.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.hoQ = new com.baidu.tbadk.data.c();
                    this.hoQ.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.hoR = new com.baidu.tbadk.data.f();
                    this.hoR.a(post.lbs_info);
                }
                this.auu = post.storecount.intValue();
                this.hoN.a(post.present);
                this.atX.setUserMap(this.userMap);
                this.atX.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.gmg = new SmallTailInfo();
                    this.gmg.id = post.signature.signature_id.intValue();
                    this.gmg.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.gmg.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.gmg.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.gmg.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.auH.add(cVar);
                    }
                }
                this.auK = post.skin_info;
                this.auN = post.lego_card;
                this.hpb = post.tpoint_post;
                if (post.agree != null) {
                    this.hpc = true;
                    this.hasAgree = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.agreeNum = post.agree.agree_num.longValue();
                    } else {
                        this.agreeNum = 0L;
                    }
                    if (post.agree.disagree_num.longValue() >= 0) {
                        this.avi = post.agree.disagree_num.longValue();
                    } else {
                        this.avi = 0L;
                    }
                    this.avk = post.agree.agree_type.intValue();
                } else {
                    this.hpc = false;
                }
                if (this.agreeNum < 0) {
                    this.agreeNum = 0L;
                }
                if (this.avi < 0) {
                    this.avi = 0L;
                }
                this.hpi = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.avt = new OriginalThreadInfo();
                    this.avt.parser(post.origin_thread_info);
                } else {
                    this.avt = null;
                }
                this.hpl = post.is_fold.intValue();
                this.fTo = post.fold_tip;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int gkn;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(this.gkn));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> hpt;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.hpt = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(e.d.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.hpt != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.hpt.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String da(Context context) {
        ArrayList<TbRichTextData> Sb;
        if (this.hoM == null || (Sb = this.hoM.Sb()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = Sb.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.Si().toString());
            } else if (next.getType() == 17) {
                String str = next.Sm().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(e.j.editor_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(e.j.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(e.j.video_title_str) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public String bEo() {
        ArrayList<TbRichTextData> Sb;
        String str;
        if (this.hoM == null || (Sb = this.hoM.Sb()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = Sb.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.Si().toString());
                } else if (next.getType() == 17) {
                    if (next.Sm() != null && next.Sm().mGifInfo != null && (str = next.Sm().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo bEp() {
        ArrayList<TbRichTextData> Sb;
        if (this.hoM != null && (Sb = this.hoM.Sb()) != null) {
            Iterator<TbRichTextData> it = Sb.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.Sh().getWidth();
                    preLoadImageInfo.height = next.Sh().getHeight();
                    preLoadImageInfo.imgUrl = next.Sh().Sw();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.Sn().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.Sn().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.Sn().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String bEq() {
        j bDM;
        PreLoadImageInfo bEp = bEp();
        if (bEp != null && !StringUtils.isNull(bEp.imgUrl)) {
            return bEp.imgUrl;
        }
        if (this.hoU != null && (bDM = this.hoU.bDM()) != null && !StringUtils.isNull(bDM.bDR())) {
            return bDM.bDR();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> Sb;
        if (this.hoM == null || (Sb = this.hoM.Sb()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = Sb.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.Sh().getWidth();
                preLoadImageInfo.height = next.Sh().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.Sh().SB()) {
                    preLoadImageInfo.imgUrl = next.Sh().Sx();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.Sh().Sw();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.Sm() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.Sm().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.Sm().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.Sm();
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
        if (this.atK == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.atK.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.hoF == 52) {
            return hoB;
        }
        if (this.hoF == 1) {
            return auL;
        }
        if (this.hoF == 36) {
            return hoz;
        }
        if (this.hoF == 40 || this.hoF == 50) {
            return atj;
        }
        if (this.hoF == 41) {
            return hoA;
        }
        if (this.hoF == 53) {
            return hoC;
        }
        if (bEj() == 1) {
            return hox;
        }
        return hoy;
    }

    public void setPostType(int i) {
        this.hoF = i;
    }

    public am bEr() {
        return this.hoN;
    }

    public void a(am amVar) {
        this.hoN = amVar;
    }

    public h bEs() {
        return this.hoU;
    }

    public com.baidu.tbadk.widget.richText.f Sl() {
        if (this.hoY != null) {
            return this.hoY;
        }
        if (this.hoM != null && v.H(this.hoM.Sb()) > 0) {
            Iterator<TbRichTextData> it = this.hoM.Sb().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.hoY = next.Sl();
                    return this.hoY;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo Sj() {
        if (this.aJX != null) {
            return this.aJX;
        }
        if (this.hoM != null && v.H(this.hoM.Sb()) > 0) {
            Iterator<TbRichTextData> it = this.hoM.Sb().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.aJX = next.Sj();
                    return this.aJX;
                }
            }
        }
        return null;
    }

    public String bEt() {
        return this.hoZ;
    }

    public String AA() {
        return this.auN;
    }

    public void AD() {
        if (this.auk == 0) {
            this.auk = 1;
        }
    }

    public long AS() {
        return this.agreeNum;
    }

    public long AT() {
        return this.avi;
    }

    public void C(long j) {
        this.agreeNum = j;
    }

    public boolean aDQ() {
        return this.hasAgree;
    }

    public void cY(int i) {
        this.avk = i;
    }

    public void ny(boolean z) {
        this.hasAgree = z;
    }

    public int AV() {
        return this.avk;
    }

    public void D(long j) {
        this.avi = j;
    }

    public OriginalThreadInfo bEu() {
        return this.avt;
    }

    public void g(OriginalThreadInfo originalThreadInfo) {
        this.avt = originalThreadInfo;
    }

    public int bEv() {
        return this.hpl;
    }

    public String bhd() {
        return this.fTo;
    }
}
