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
    private TbRichTextVoiceInfo aKz;
    private Agree agree;
    @Deprecated
    private String authorId;
    private long avK;
    private int avM;
    private OriginalThreadInfo avV;
    private SkinInfo avm;
    private String avp;
    private String bimg_url;
    private String fTz;
    private boolean fUL;
    private String fUl;
    private SmallTailInfo gnj;
    private ArrayList<PostData> hpO;
    private com.baidu.tbadk.data.c hpV;
    private com.baidu.tbadk.data.f hpW;
    private h hpZ;
    private ay hqa;
    public boolean hqc;
    private com.baidu.tbadk.widget.richText.f hqd;
    private String hqe;
    private String hqf;
    private TPointPost hqg;
    public int hqj;
    public AlaLiveInfoCoreData hqo;
    public am hqu;
    public int locate;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId hpC = BdUniqueId.gen();
    public static final BdUniqueId hpD = BdUniqueId.gen();
    public static final BdUniqueId avn = BdUniqueId.gen();
    public static final BdUniqueId hpE = BdUniqueId.gen();
    public static final BdUniqueId atL = BdUniqueId.gen();
    public static final BdUniqueId hpF = BdUniqueId.gen();
    public static final BdUniqueId hpG = BdUniqueId.gen();
    public static final BdUniqueId hpH = BdUniqueId.gen();
    public static final BdUniqueId hpI = BdUniqueId.gen();
    public static boolean hpJ = false;
    private int hpK = 0;
    private boolean hpP = false;
    private ArrayList<PostData> hpQ = null;
    private TbRichText hpR = null;
    private boolean hpU = false;
    private boolean hpX = false;
    private boolean hpY = false;
    public boolean hqb = false;
    public int auM = 0;
    private boolean hqh = false;
    private long agreeNum = 0;
    private boolean hasAgree = false;
    public boolean dSk = false;
    public boolean hqi = false;
    public boolean hqk = false;
    public boolean hql = true;
    public boolean hqm = false;
    public boolean hqn = false;
    private boolean hqp = false;
    private int hqq = 0;
    private boolean hqr = true;
    public boolean hqs = false;
    public boolean hqt = false;
    private b hqv = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.hqu != null) {
                am DY = PostData.this.hqu.DY();
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
    private MetaData aum = new MetaData();
    private ArrayList<k> hpL = new ArrayList<>();
    private ArrayList<k> hpM = new ArrayList<>();
    private int hpN = 0;
    private int auW = 0;
    private PraiseData auz = new PraiseData();
    private com.baidu.tbadk.core.data.am hpS = new com.baidu.tbadk.core.data.am();
    private c hpT = new c();
    private ArrayList<com.baidu.tbadk.data.c> avj = new ArrayList<>();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.hpO = null;
        this.hqj = 0;
        this.hpO = new ArrayList<>();
        this.hqj = 0;
    }

    public void kA(boolean z) {
        this.fUL = z;
    }

    public boolean bEK() {
        return this.fUL;
    }

    public ArrayList<PostData> bEL() {
        return this.hpQ;
    }

    public void bEM() {
        this.hpQ.clear();
        this.hpQ = null;
        this.hpP = false;
    }

    public void r(PostData postData) {
        if (postData != null) {
            if (this.hpQ == null) {
                this.hpQ = new ArrayList<>();
                if (v.H(this.hpO) > 2) {
                    this.hpQ.addAll(v.b(this.hpO, 0, 2));
                } else {
                    this.hpQ.addAll(this.hpO);
                }
            }
            this.hpQ.add(postData);
        }
    }

    public void s(PostData postData) {
        if (postData != null && this.hpO != null) {
            this.hpO.add(postData);
            bEQ();
        }
    }

    public void vW(String str) {
        if (this.hpQ != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.hpQ.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.hpQ.remove(next);
                    return;
                }
            }
        }
    }

    public void nv(boolean z) {
        this.hqr = z;
    }

    public boolean bEN() {
        return this.hqr;
    }

    public void nw(boolean z) {
        this.hpP = z;
    }

    public boolean bEO() {
        return this.hpP;
    }

    public ArrayList<PostData> bEP() {
        return this.hpO;
    }

    public void bEQ() {
        this.hpN++;
    }

    public void bER() {
        this.hpN--;
    }

    public void vK(int i) {
        this.hpN = i;
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
        return this.fTz;
    }

    public int bES() {
        return this.floor_num;
    }

    public void vL(int i) {
        this.floor_num = i;
    }

    public boolean bET() {
        return this.hpY;
    }

    public void nx(boolean z) {
        this.hpY = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = ao.M(j);
    }

    public MetaData zT() {
        return this.aum;
    }

    public void a(MetaData metaData) {
        this.aum = metaData;
    }

    public void a(PraiseData praiseData) {
        this.auz = praiseData;
    }

    public TbRichText bEU() {
        return this.hpR;
    }

    public void c(TbRichText tbRichText) {
        this.hpR = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo bor() {
        return this.gnj;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.gnj = smallTailInfo;
    }

    public com.baidu.tbadk.data.f bEV() {
        return this.hpW;
    }

    public SkinInfo Ap() {
        return this.avm;
    }

    public void ny(boolean z) {
        this.hqp = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.hpR != null && this.hpR.Sx() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.aum != null && this.aum.getIs_bawu() == 1) {
                    if (this.fUL) {
                        str = " 品牌官";
                    } else if ("manager".equals(this.aum.getBawu_type())) {
                        str = " 吧主";
                    } else if ("assist".equals(this.aum.getBawu_type())) {
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
                                            PostData.this.hpR.isChanged = true;
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
            if (!StringUtils.isNull(this.aum.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.aum.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.aum == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.aum.getName_show() + str + "：");
                str2 = this.aum.getUserName();
                str3 = this.aum.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.aum.getSealPrefix())) {
                Bitmap dO = al.dO(e.f.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(dO);
                if (dO != null) {
                    bitmapDrawable.setBounds(0, 0, dO.getWidth(), dO.getHeight());
                }
                com.baidu.tbadk.core.view.m mVar = new com.baidu.tbadk.core.view.m(bitmapDrawable);
                mVar.setOffset(com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), e.C0210e.ds2));
                int size = arrayList.size() + this.aum.getSealPrefix().length() + 1;
                spannableString.setSpan(mVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.hqv), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.aum != null && this.aum.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.e X = X(z, this.aum != null && this.aum.getIs_bawu() == 1);
                if (X != null) {
                    if (this.aum != null) {
                        int i3 = 0;
                        if (this.aum.getName_show() != null) {
                            i3 = this.aum.getName_show().length();
                        }
                        spannableString.setSpan(X, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(X, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> Sx = this.hpR.Sx();
            if (Sx != null && Sx.size() > 0) {
                TbRichTextData tbRichTextData2 = Sx.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.SE() != null) {
                    if (this.hqp) {
                        int indexOf = tbRichTextData2.SE().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.SE().delete(0, indexOf + 1);
                        }
                        this.hqp = false;
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
            this.hqs = true;
        }
    }

    private com.baidu.tbadk.core.view.e X(boolean z, boolean z2) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        return new com.baidu.tbadk.core.view.e(com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds1), com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds4), this.fUL ? e.d.cp_link_tip_a_alpha50 : e.d.cp_cont_j_alpha50, com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds30), this.fUL ? e.d.cp_link_tip_a : e.d.cp_cont_j, com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds12), com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds42));
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
        return this.hpN;
    }

    public void cY(Context context) {
        int type;
        int i;
        int i2;
        if (this.hpL != null) {
            int i3 = -1;
            int size = this.hpM.size();
            if (size > 0) {
                try {
                    i3 = this.hpM.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.hpL.size()) {
                k kVar = this.hpL.get(i4);
                if (k.bS(i5, kVar.getType())) {
                    this.hpM.get(size - 1).b(kVar.cX(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.hpM.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.cX(context));
                        this.hpM.add(kVar2);
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
            if (this.hpR != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.hpR.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.hpM == null || this.hpM.size() == 0) {
                cY(context);
            }
            ArrayList<k> arrayList = this.hpM;
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
                this.hpX = subPostList.is_giftpost.intValue() == 1;
                this.agree = subPostList.agree;
                if (this.agree != null) {
                    this.avM = this.agree.agree_type.intValue();
                    this.hasAgree = this.agree.has_agree.intValue() == 1;
                    this.agreeNum = this.agree.agree_num.longValue() > 0 ? this.agree.agree_num.longValue() : 0L;
                    this.avK = this.agree.disagree_num.longValue() > 0 ? this.agree.disagree_num.longValue() : 0L;
                }
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aum = metaData;
                }
                if ((this.aum.getUserId() == null || this.aum.getUserId().length() <= 0 || this.aum.getUserId().equals("0")) && metaData2 != null) {
                    this.aum = metaData2;
                }
                this.hpR = TbRichTextView.a(context, subPostList.content, z);
                if (this.hpR != null) {
                    this.hpR.setPostId(com.baidu.adp.lib.g.b.d(this.id, -1L));
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
                this.fTz = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aum = metaData;
                }
                this.dSk = post.need_log.intValue() == 1;
                this.hqi = post.img_num_abtest.intValue() == 1;
                this.hqa = new ay();
                this.hqa.parserProtobuf(post.from_forum);
                if (this.aum.getUserId() == null || this.aum.getUserId().length() <= 0 || this.aum.getUserId().equals("0")) {
                    this.aum.parserProtobuf(post.author);
                }
                if (this.aum != null && context != null) {
                    this.hqe = this.aum.getUserName() + context.getResources().getString(e.j.somebodys_portrait);
                    this.hqf = String.format(TbadkCoreApplication.getInst().getString(e.j.degree_in_forum), Integer.valueOf(this.aum.getLevel_id()));
                }
                this.hpU = post.is_ntitle.intValue() == 1;
                this.hpN = post.sub_post_number.intValue();
                this.hpZ = new h(post.tpoint_post);
                this.hpR = TbRichTextView.a(context, post.content, true);
                if (this.hpR != null) {
                    this.hpR.setPostId(com.baidu.adp.lib.g.b.d(this.id, -1L));
                    this.hpR.gU(this.floor_num);
                    if (this.aum != null) {
                        this.hpR.setAuthorId(this.aum.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.hpX = subPostList.is_giftpost.intValue() == 1;
                            postData.agree = subPostList.agree;
                            postData.setUserMap(this.userMap);
                            postData.kA(this.fUL);
                            postData.a(subPostList, context);
                            this.hpO.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.hpT.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.hpV = new com.baidu.tbadk.data.c();
                    this.hpV.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.hpW = new com.baidu.tbadk.data.f();
                    this.hpW.a(post.lbs_info);
                }
                this.auW = post.storecount.intValue();
                this.hpS.a(post.present);
                this.auz.setUserMap(this.userMap);
                this.auz.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.gnj = new SmallTailInfo();
                    this.gnj.id = post.signature.signature_id.intValue();
                    this.gnj.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.gnj.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.gnj.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.gnj.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.avj.add(cVar);
                    }
                }
                this.avm = post.skin_info;
                this.avp = post.lego_card;
                this.hqg = post.tpoint_post;
                if (post.agree != null) {
                    this.hqh = true;
                    this.hasAgree = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.agreeNum = post.agree.agree_num.longValue();
                    } else {
                        this.agreeNum = 0L;
                    }
                    if (post.agree.disagree_num.longValue() >= 0) {
                        this.avK = post.agree.disagree_num.longValue();
                    } else {
                        this.avK = 0L;
                    }
                    this.avM = post.agree.agree_type.intValue();
                } else {
                    this.hqh = false;
                }
                if (this.agreeNum < 0) {
                    this.agreeNum = 0L;
                }
                if (this.avK < 0) {
                    this.avK = 0L;
                }
                this.hqn = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.avV = new OriginalThreadInfo();
                    this.avV.parser(post.origin_thread_info);
                } else {
                    this.avV = null;
                }
                this.hqq = post.is_fold.intValue();
                this.fUl = post.fold_tip;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int glq;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(this.glq));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> hqB;
        private b hqC;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.hqB = new SoftReference<>(context);
            this.hqC = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(e.d.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.hqB != null) {
                if (this.hqC != null) {
                    this.hqC.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.hqB.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String da(Context context) {
        ArrayList<TbRichTextData> Sx;
        if (this.hpR == null || (Sx = this.hpR.Sx()) == null) {
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
        if (this.hpR == null || (Sx = this.hpR.Sx()) == null) {
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
        if (this.hpR != null && (Sx = this.hpR.Sx()) != null) {
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
        if (this.hpZ != null && (bEv = this.hpZ.bEv()) != null && !StringUtils.isNull(bEv.bEA())) {
            return bEv.bEA();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> Sx;
        if (this.hpR == null || (Sx = this.hpR.Sx()) == null) {
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
        if (this.aum == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.aum.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.hpK == 52) {
            return hpG;
        }
        if (this.hpK == 1) {
            return avn;
        }
        if (this.hpK == 36) {
            return hpE;
        }
        if (this.hpK == 40 || this.hpK == 50) {
            return atL;
        }
        if (this.hpK == 41) {
            return hpF;
        }
        if (this.hpK == 53) {
            return hpH;
        }
        if (bES() == 1) {
            return hpC;
        }
        return hpD;
    }

    public void setPostType(int i) {
        this.hpK = i;
    }

    public com.baidu.tbadk.core.data.am bFa() {
        return this.hpS;
    }

    public void a(com.baidu.tbadk.core.data.am amVar) {
        this.hpS = amVar;
    }

    public h bFb() {
        return this.hpZ;
    }

    public com.baidu.tbadk.widget.richText.f SH() {
        if (this.hqd != null) {
            return this.hqd;
        }
        if (this.hpR != null && v.H(this.hpR.Sx()) > 0) {
            Iterator<TbRichTextData> it = this.hpR.Sx().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.hqd = next.SH();
                    return this.hqd;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo SF() {
        if (this.aKz != null) {
            return this.aKz;
        }
        if (this.hpR != null && v.H(this.hpR.Sx()) > 0) {
            Iterator<TbRichTextData> it = this.hpR.Sx().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.aKz = next.SF();
                    return this.aKz;
                }
            }
        }
        return null;
    }

    public String bFc() {
        return this.hqe;
    }

    public String AN() {
        return this.avp;
    }

    public void AQ() {
        if (this.auM == 0) {
            this.auM = 1;
        }
    }

    public long Bf() {
        return this.agreeNum;
    }

    public long Bg() {
        return this.avK;
    }

    public void C(long j) {
        this.agreeNum = j;
    }

    public boolean aEn() {
        return this.hasAgree;
    }

    public void cY(int i) {
        this.avM = i;
    }

    public void nz(boolean z) {
        this.hasAgree = z;
    }

    public int Bi() {
        return this.avM;
    }

    public void D(long j) {
        this.avK = j;
    }

    public OriginalThreadInfo bFd() {
        return this.avV;
    }

    public void g(OriginalThreadInfo originalThreadInfo) {
        this.avV = originalThreadInfo;
    }

    public int bFe() {
        return this.hqq;
    }

    public String bhH() {
        return this.fUl;
    }
}
