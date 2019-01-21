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
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
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
    private TbRichTextVoiceInfo aKA;
    private Agree agree;
    @Deprecated
    private String authorId;
    private long avL;
    private int avN;
    private OriginalThreadInfo avW;
    private SkinInfo avn;
    private String avq;
    private String bimg_url;
    private String fTA;
    private boolean fUM;
    private String fUm;
    private SmallTailInfo gnk;
    private ArrayList<PostData> hpP;
    private com.baidu.tbadk.data.c hpW;
    private com.baidu.tbadk.data.f hpX;
    private h hqa;
    private ay hqb;
    public boolean hqd;
    private com.baidu.tbadk.widget.richText.f hqe;
    private String hqf;
    private String hqg;
    private TPointPost hqh;
    public int hqk;
    public AlaLiveInfoCoreData hqp;
    public am hqv;
    public int locate;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId hpD = BdUniqueId.gen();
    public static final BdUniqueId hpE = BdUniqueId.gen();
    public static final BdUniqueId avo = BdUniqueId.gen();
    public static final BdUniqueId hpF = BdUniqueId.gen();
    public static final BdUniqueId atM = BdUniqueId.gen();
    public static final BdUniqueId hpG = BdUniqueId.gen();
    public static final BdUniqueId hpH = BdUniqueId.gen();
    public static final BdUniqueId hpI = BdUniqueId.gen();
    public static final BdUniqueId hpJ = BdUniqueId.gen();
    public static boolean hpK = false;
    private int hpL = 0;
    private boolean hpQ = false;
    private ArrayList<PostData> hpR = null;
    private TbRichText hpS = null;
    private boolean hpV = false;
    private boolean hpY = false;
    private boolean hpZ = false;
    public boolean hqc = false;
    public int auN = 0;
    private boolean hqi = false;
    private long agreeNum = 0;
    private boolean hasAgree = false;
    public boolean dSl = false;
    public boolean hqj = false;
    public boolean hql = false;
    public boolean hqm = true;
    public boolean hqn = false;
    public boolean hqo = false;
    private boolean hqq = false;
    private int hqr = 0;
    private boolean hqs = true;
    public boolean hqt = false;
    public boolean hqu = false;
    private b hqw = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.hqv != null) {
                am DY = PostData.this.hqv.DY();
                DY.delete("obj_locate");
                DY.y("obj_locate", 7);
                TiebaStatic.log(DY);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData aun = new MetaData();
    private ArrayList<k> hpM = new ArrayList<>();
    private ArrayList<k> hpN = new ArrayList<>();
    private int hpO = 0;
    private int auX = 0;
    private PraiseData auA = new PraiseData();
    private com.baidu.tbadk.core.data.am hpT = new com.baidu.tbadk.core.data.am();
    private c hpU = new c();
    private ArrayList<com.baidu.tbadk.data.c> avk = new ArrayList<>();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.hpP = null;
        this.hqk = 0;
        this.hpP = new ArrayList<>();
        this.hqk = 0;
    }

    public void kA(boolean z) {
        this.fUM = z;
    }

    public boolean bEK() {
        return this.fUM;
    }

    public ArrayList<PostData> bEL() {
        return this.hpR;
    }

    public void bEM() {
        this.hpR.clear();
        this.hpR = null;
        this.hpQ = false;
    }

    public void r(PostData postData) {
        if (postData != null) {
            if (this.hpR == null) {
                this.hpR = new ArrayList<>();
                if (v.H(this.hpP) > 2) {
                    this.hpR.addAll(v.b(this.hpP, 0, 2));
                } else {
                    this.hpR.addAll(this.hpP);
                }
            }
            this.hpR.add(postData);
        }
    }

    public void s(PostData postData) {
        if (postData != null && this.hpP != null) {
            this.hpP.add(postData);
            bEQ();
        }
    }

    public void vW(String str) {
        if (this.hpR != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.hpR.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.hpR.remove(next);
                    return;
                }
            }
        }
    }

    public void nv(boolean z) {
        this.hqs = z;
    }

    public boolean bEN() {
        return this.hqs;
    }

    public void nw(boolean z) {
        this.hpQ = z;
    }

    public boolean bEO() {
        return this.hpQ;
    }

    public ArrayList<PostData> bEP() {
        return this.hpP;
    }

    public void bEQ() {
        this.hpO++;
    }

    public void bER() {
        this.hpO--;
    }

    public void vK(int i) {
        this.hpO = i;
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

    public String bhs() {
        return this.fTA;
    }

    public int bES() {
        return this.floor_num;
    }

    public void vL(int i) {
        this.floor_num = i;
    }

    public boolean bET() {
        return this.hpZ;
    }

    public void nx(boolean z) {
        this.hpZ = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = ao.M(j);
    }

    public MetaData zT() {
        return this.aun;
    }

    public void a(MetaData metaData) {
        this.aun = metaData;
    }

    public void a(PraiseData praiseData) {
        this.auA = praiseData;
    }

    public TbRichText bEU() {
        return this.hpS;
    }

    public void c(TbRichText tbRichText) {
        this.hpS = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo bor() {
        return this.gnk;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.gnk = smallTailInfo;
    }

    public com.baidu.tbadk.data.f bEV() {
        return this.hpX;
    }

    public SkinInfo Ap() {
        return this.avn;
    }

    public void ny(boolean z) {
        this.hqq = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.hpS != null && this.hpS.Sx() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.aun != null && this.aun.getIs_bawu() == 1) {
                    if (this.fUM) {
                        str = " 品牌官";
                    } else if ("manager".equals(this.aun.getBawu_type())) {
                        str = " 吧主";
                    } else if ("assist".equals(this.aun.getBawu_type())) {
                        str = " 小吧主";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = zT().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.jA().a(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.f.c.jA().a(next.getIcon(), 21, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.f.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((AnonymousClass1) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.ou()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.hpS.isChanged = true;
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
            if (!StringUtils.isNull(this.aun.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.aun.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.aun == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.aun.getName_show() + str + "：");
                str2 = this.aun.getUserName();
                str3 = this.aun.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.aun.getSealPrefix())) {
                Bitmap dO = al.dO(e.f.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(dO);
                if (dO != null) {
                    bitmapDrawable.setBounds(0, 0, dO.getWidth(), dO.getHeight());
                }
                com.baidu.tbadk.core.view.m mVar = new com.baidu.tbadk.core.view.m(bitmapDrawable);
                mVar.setOffset(com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), e.C0210e.ds2));
                int size = arrayList.size() + this.aun.getSealPrefix().length() + 1;
                spannableString.setSpan(mVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.hqw), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.aun != null && this.aun.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.e X = X(z, this.aun != null && this.aun.getIs_bawu() == 1);
                if (X != null) {
                    if (this.aun != null) {
                        int i3 = 0;
                        if (this.aun.getName_show() != null) {
                            i3 = this.aun.getName_show().length();
                        }
                        spannableString.setSpan(X, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(X, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> Sx = this.hpS.Sx();
            if (Sx != null && Sx.size() > 0) {
                TbRichTextData tbRichTextData2 = Sx.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.SE() != null) {
                    if (this.hqq) {
                        int indexOf = tbRichTextData2.SE().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.SE().delete(0, indexOf + 1);
                        }
                        this.hqq = false;
                    }
                    tbRichTextData2.gV(sb.length());
                    tbRichTextData2.SE().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= Sx.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (Sx.get(i5) == null || Sx.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo SF = Sx.get(i5).SF();
                            Sx.remove(i5);
                            tbRichTextVoiceInfo = SF;
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
                    Sx.add(0, tbRichTextData);
                }
            }
            this.hqt = true;
        }
    }

    private com.baidu.tbadk.core.view.e X(boolean z, boolean z2) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        return new com.baidu.tbadk.core.view.e(com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds1), com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds4), this.fUM ? e.d.cp_link_tip_a_alpha50 : e.d.cp_cont_j_alpha50, com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds30), this.fUM ? e.d.cp_link_tip_a : e.d.cp_cont_j, com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds12), com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds42));
    }

    protected Drawable h(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap ot;
        if (aVar == null || (ot = aVar.ot()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(ot);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(e.C0210e.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(e.C0210e.ds36));
        return bitmapDrawable;
    }

    public int bEW() {
        return this.hpO;
    }

    public void cY(Context context) {
        int type;
        int i;
        int i2;
        if (this.hpM != null) {
            int i3 = -1;
            int size = this.hpN.size();
            if (size > 0) {
                try {
                    i3 = this.hpN.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.hpM.size()) {
                k kVar = this.hpM.get(i4);
                if (k.bS(i5, kVar.getType())) {
                    this.hpN.get(size - 1).b(kVar.cX(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.hpN.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.cX(context));
                        this.hpN.add(kVar2);
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
            if (this.hpS != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.hpS.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.hpN == null || this.hpN.size() == 0) {
                cY(context);
            }
            ArrayList<k> arrayList = this.hpN;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.bED() != null) {
                            sb.append((CharSequence) next.bED());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(e.j.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(e.j.voice_str));
                    } else if (next.getType() == 2) {
                        String hU = TbFaceManager.NL().hU(next.getText());
                        if (hU != null) {
                            sb.append("[");
                            sb.append(hU);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !ao.isEmpty(next.bEC())) {
                        sb.append("[").append(next.bEC()).append("]");
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
                this.hpY = subPostList.is_giftpost.intValue() == 1;
                this.agree = subPostList.agree;
                if (this.agree != null) {
                    this.avN = this.agree.agree_type.intValue();
                    this.hasAgree = this.agree.has_agree.intValue() == 1;
                    this.agreeNum = this.agree.agree_num.longValue() > 0 ? this.agree.agree_num.longValue() : 0L;
                    this.avL = this.agree.disagree_num.longValue() > 0 ? this.agree.disagree_num.longValue() : 0L;
                }
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aun = metaData;
                }
                if ((this.aun.getUserId() == null || this.aun.getUserId().length() <= 0 || this.aun.getUserId().equals("0")) && metaData2 != null) {
                    this.aun = metaData2;
                }
                this.hpS = TbRichTextView.a(context, subPostList.content, z);
                if (this.hpS != null) {
                    this.hpS.setPostId(com.baidu.adp.lib.g.b.d(this.id, -1L));
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
                this.fTA = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aun = metaData;
                }
                this.dSl = post.need_log.intValue() == 1;
                this.hqj = post.img_num_abtest.intValue() == 1;
                this.hqb = new ay();
                this.hqb.parserProtobuf(post.from_forum);
                if (this.aun.getUserId() == null || this.aun.getUserId().length() <= 0 || this.aun.getUserId().equals("0")) {
                    this.aun.parserProtobuf(post.author);
                }
                if (this.aun != null && context != null) {
                    this.hqf = this.aun.getUserName() + context.getResources().getString(e.j.somebodys_portrait);
                    this.hqg = String.format(TbadkCoreApplication.getInst().getString(e.j.degree_in_forum), Integer.valueOf(this.aun.getLevel_id()));
                }
                this.hpV = post.is_ntitle.intValue() == 1;
                this.hpO = post.sub_post_number.intValue();
                this.hqa = new h(post.tpoint_post);
                this.hpS = TbRichTextView.a(context, post.content, true);
                if (this.hpS != null) {
                    this.hpS.setPostId(com.baidu.adp.lib.g.b.d(this.id, -1L));
                    this.hpS.gU(this.floor_num);
                    if (this.aun != null) {
                        this.hpS.setAuthorId(this.aun.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.hpY = subPostList.is_giftpost.intValue() == 1;
                            postData.agree = subPostList.agree;
                            postData.setUserMap(this.userMap);
                            postData.kA(this.fUM);
                            postData.a(subPostList, context);
                            this.hpP.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.hpU.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.hpW = new com.baidu.tbadk.data.c();
                    this.hpW.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.hpX = new com.baidu.tbadk.data.f();
                    this.hpX.a(post.lbs_info);
                }
                this.auX = post.storecount.intValue();
                this.hpT.a(post.present);
                this.auA.setUserMap(this.userMap);
                this.auA.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.gnk = new SmallTailInfo();
                    this.gnk.id = post.signature.signature_id.intValue();
                    this.gnk.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.gnk.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.gnk.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.gnk.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.avk.add(cVar);
                    }
                }
                this.avn = post.skin_info;
                this.avq = post.lego_card;
                this.hqh = post.tpoint_post;
                if (post.agree != null) {
                    this.hqi = true;
                    this.hasAgree = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.agreeNum = post.agree.agree_num.longValue();
                    } else {
                        this.agreeNum = 0L;
                    }
                    if (post.agree.disagree_num.longValue() >= 0) {
                        this.avL = post.agree.disagree_num.longValue();
                    } else {
                        this.avL = 0L;
                    }
                    this.avN = post.agree.agree_type.intValue();
                } else {
                    this.hqi = false;
                }
                if (this.agreeNum < 0) {
                    this.agreeNum = 0L;
                }
                if (this.avL < 0) {
                    this.avL = 0L;
                }
                this.hqo = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.avW = new OriginalThreadInfo();
                    this.avW.parser(post.origin_thread_info);
                } else {
                    this.avW = null;
                }
                this.hqr = post.is_fold.intValue();
                this.fUm = post.fold_tip;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int glr;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(this.glr));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> hqC;
        private b hqD;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.hqC = new SoftReference<>(context);
            this.hqD = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(e.d.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.hqC != null) {
                if (this.hqD != null) {
                    this.hqD.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.hqC.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String da(Context context) {
        ArrayList<TbRichTextData> Sx;
        if (this.hpS == null || (Sx = this.hpS.Sx()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = Sx.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.SE().toString());
            } else if (next.getType() == 17) {
                String str = next.SI().mGifInfo.mSharpText;
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

    public String bEX() {
        ArrayList<TbRichTextData> Sx;
        String str;
        if (this.hpS == null || (Sx = this.hpS.Sx()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = Sx.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.SE().toString());
                } else if (next.getType() == 17) {
                    if (next.SI() != null && next.SI().mGifInfo != null && (str = next.SI().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo bEY() {
        ArrayList<TbRichTextData> Sx;
        if (this.hpS != null && (Sx = this.hpS.Sx()) != null) {
            Iterator<TbRichTextData> it = Sx.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.SD().getWidth();
                    preLoadImageInfo.height = next.SD().getHeight();
                    preLoadImageInfo.imgUrl = next.SD().SS();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.SJ().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.SJ().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.SJ().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String bEZ() {
        j bEv;
        PreLoadImageInfo bEY = bEY();
        if (bEY != null && !StringUtils.isNull(bEY.imgUrl)) {
            return bEY.imgUrl;
        }
        if (this.hqa != null && (bEv = this.hqa.bEv()) != null && !StringUtils.isNull(bEv.bEA())) {
            return bEv.bEA();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> Sx;
        if (this.hpS == null || (Sx = this.hpS.Sx()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = Sx.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.SD().getWidth();
                preLoadImageInfo.height = next.SD().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.SD().SX()) {
                    preLoadImageInfo.imgUrl = next.SD().ST();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.SD().SS();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.SI() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.SI().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.SI().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.SI();
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
        if (this.aun == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.aun.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.hpL == 52) {
            return hpH;
        }
        if (this.hpL == 1) {
            return avo;
        }
        if (this.hpL == 36) {
            return hpF;
        }
        if (this.hpL == 40 || this.hpL == 50) {
            return atM;
        }
        if (this.hpL == 41) {
            return hpG;
        }
        if (this.hpL == 53) {
            return hpI;
        }
        if (bES() == 1) {
            return hpD;
        }
        return hpE;
    }

    public void setPostType(int i) {
        this.hpL = i;
    }

    public com.baidu.tbadk.core.data.am bFa() {
        return this.hpT;
    }

    public void a(com.baidu.tbadk.core.data.am amVar) {
        this.hpT = amVar;
    }

    public h bFb() {
        return this.hqa;
    }

    public com.baidu.tbadk.widget.richText.f SH() {
        if (this.hqe != null) {
            return this.hqe;
        }
        if (this.hpS != null && v.H(this.hpS.Sx()) > 0) {
            Iterator<TbRichTextData> it = this.hpS.Sx().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.hqe = next.SH();
                    return this.hqe;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo SF() {
        if (this.aKA != null) {
            return this.aKA;
        }
        if (this.hpS != null && v.H(this.hpS.Sx()) > 0) {
            Iterator<TbRichTextData> it = this.hpS.Sx().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.aKA = next.SF();
                    return this.aKA;
                }
            }
        }
        return null;
    }

    public String bFc() {
        return this.hqf;
    }

    public String AN() {
        return this.avq;
    }

    public void AQ() {
        if (this.auN == 0) {
            this.auN = 1;
        }
    }

    public long Bf() {
        return this.agreeNum;
    }

    public long Bg() {
        return this.avL;
    }

    public void C(long j) {
        this.agreeNum = j;
    }

    public boolean aEn() {
        return this.hasAgree;
    }

    public void cY(int i) {
        this.avN = i;
    }

    public void nz(boolean z) {
        this.hasAgree = z;
    }

    public int Bi() {
        return this.avN;
    }

    public void D(long j) {
        this.avL = j;
    }

    public OriginalThreadInfo bFd() {
        return this.avW;
    }

    public void g(OriginalThreadInfo originalThreadInfo) {
        this.avW = originalThreadInfo;
    }

    public int bFe() {
        return this.hqr;
    }

    public String bhH() {
        return this.fUm;
    }
}
