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
    private TbRichTextVoiceInfo aGv;
    private Agree agree;
    private long arI;
    private int arK;
    private OriginalThreadInfo arT;
    private SkinInfo ark;
    private String arn;
    @Deprecated
    private String authorId;
    private String bimg_url;
    private String fIU;
    private String fJG;
    private boolean fKg;
    private SmallTailInfo gcx;
    private ArrayList<PostData> heE;
    private com.baidu.tbadk.data.c heL;
    private com.baidu.tbadk.data.f heM;
    private h heP;
    private ay heQ;
    public boolean heS;
    private com.baidu.tbadk.widget.richText.f heT;
    private String heU;
    private String heV;
    private TPointPost heW;
    public int heZ;
    public AlaLiveInfoCoreData hfe;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId hes = BdUniqueId.gen();
    public static final BdUniqueId het = BdUniqueId.gen();
    public static final BdUniqueId arl = BdUniqueId.gen();
    public static final BdUniqueId heu = BdUniqueId.gen();
    public static final BdUniqueId apJ = BdUniqueId.gen();
    public static final BdUniqueId hev = BdUniqueId.gen();
    public static final BdUniqueId hew = BdUniqueId.gen();
    public static final BdUniqueId hex = BdUniqueId.gen();
    public static final BdUniqueId hey = BdUniqueId.gen();
    public static boolean hez = false;
    private int heA = 0;
    private boolean heF = false;
    private ArrayList<PostData> heG = null;
    private TbRichText heH = null;
    private boolean heK = false;
    private boolean heN = false;
    private boolean heO = false;
    public boolean heR = false;
    public int aqK = 0;
    private boolean heX = false;
    private long agreeNum = 0;
    private boolean hasAgree = false;
    public boolean dIo = false;
    public boolean heY = false;
    public boolean hfa = false;
    public boolean hfb = true;
    public boolean hfc = false;
    public boolean hfd = false;
    private boolean hff = false;
    private int hfg = 0;
    private boolean hfh = true;
    public boolean hfi = false;
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData aqk = new MetaData();
    private ArrayList<k> heB = new ArrayList<>();
    private ArrayList<k> heC = new ArrayList<>();
    private int heD = 0;
    private int aqU = 0;
    private PraiseData aqx = new PraiseData();
    private am heI = new am();
    private c heJ = new c();
    private ArrayList<com.baidu.tbadk.data.c> arh = new ArrayList<>();

    public PostData() {
        this.heE = null;
        this.heZ = 0;
        this.heE = new ArrayList<>();
        this.heZ = 0;
    }

    public void ku(boolean z) {
        this.fKg = z;
    }

    public boolean bBp() {
        return this.fKg;
    }

    public ArrayList<PostData> bBq() {
        return this.heG;
    }

    public void bBr() {
        this.heG.clear();
        this.heG = null;
        this.heF = false;
    }

    public void p(PostData postData) {
        if (postData != null) {
            if (this.heG == null) {
                this.heG = new ArrayList<>();
                if (v.H(this.heE) > 2) {
                    this.heG.addAll(v.b(this.heE, 0, 2));
                } else {
                    this.heG.addAll(this.heE);
                }
            }
            this.heG.add(postData);
        }
    }

    public void q(PostData postData) {
        if (postData != null && this.heE != null) {
            this.heE.add(postData);
            bBv();
        }
    }

    public void vc(String str) {
        if (this.heG != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.heG.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.heG.remove(next);
                    return;
                }
            }
        }
    }

    public void np(boolean z) {
        this.hfh = z;
    }

    public boolean bBs() {
        return this.hfh;
    }

    public void nq(boolean z) {
        this.heF = z;
    }

    public boolean bBt() {
        return this.heF;
    }

    public ArrayList<PostData> bBu() {
        return this.heE;
    }

    public void bBv() {
        this.heD++;
    }

    public void bBw() {
        this.heD--;
    }

    public void uY(int i) {
        this.heD = i;
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

    public String bem() {
        return this.fIU;
    }

    public int bBx() {
        return this.floor_num;
    }

    public void uZ(int i) {
        this.floor_num = i;
    }

    public boolean bBy() {
        return this.heO;
    }

    public void nr(boolean z) {
        this.heO = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = ao.E(j);
    }

    public MetaData yC() {
        return this.aqk;
    }

    public void a(MetaData metaData) {
        this.aqk = metaData;
    }

    public void a(PraiseData praiseData) {
        this.aqx = praiseData;
    }

    public TbRichText bBz() {
        return this.heH;
    }

    public void c(TbRichText tbRichText) {
        this.heH = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo blf() {
        return this.gcx;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.gcx = smallTailInfo;
    }

    public com.baidu.tbadk.data.f bBA() {
        return this.heM;
    }

    public SkinInfo yY() {
        return this.ark;
    }

    public void ns(boolean z) {
        this.hff = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.heH != null && this.heH.QT() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.aqk != null && this.aqk.getIs_bawu() == 1) {
                    if (this.fKg) {
                        str = " 品牌官";
                    } else if ("manager".equals(this.aqk.getBawu_type())) {
                        str = " 吧主";
                    } else if ("assist".equals(this.aqk.getBawu_type())) {
                        str = " 小吧主";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = yC().getTShowInfoNew();
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
                                        super.onLoaded((C03061) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.or()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.heH.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004005));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.h(aVar);
                        }
                    }, 0, 1);
                    cVar.d(0, 0, TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(e.C0200e.ds32), TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(e.C0200e.ds32));
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.aqk.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.aqk.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.aqk == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.aqk.getName_show() + str + "：");
                str2 = this.aqk.getUserName();
                str3 = this.aqk.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.aqk.getSealPrefix())) {
                Bitmap dA = al.dA(e.f.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(dA);
                if (dA != null) {
                    bitmapDrawable.setBounds(0, 0, dA.getWidth(), dA.getHeight());
                }
                com.baidu.tbadk.core.view.m mVar = new com.baidu.tbadk.core.view.m(bitmapDrawable);
                mVar.setOffset(com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), e.C0200e.ds2));
                int size = arrayList.size() + this.aqk.getSealPrefix().length() + 1;
                spannableString.setSpan(mVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.aqk != null && this.aqk.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.e X = X(z, this.aqk != null && this.aqk.getIs_bawu() == 1);
                if (X != null) {
                    if (this.aqk != null) {
                        int i3 = 0;
                        if (this.aqk.getName_show() != null) {
                            i3 = this.aqk.getName_show().length();
                        }
                        spannableString.setSpan(X, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(X, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> QT = this.heH.QT();
            if (QT != null && QT.size() > 0) {
                TbRichTextData tbRichTextData2 = QT.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.Ra() != null) {
                    if (this.hff) {
                        int indexOf = tbRichTextData2.Ra().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.Ra().delete(0, indexOf + 1);
                        }
                        this.hff = false;
                    }
                    tbRichTextData2.gG(sb.length());
                    tbRichTextData2.Ra().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= QT.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (QT.get(i5) == null || QT.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo Rb = QT.get(i5).Rb();
                            QT.remove(i5);
                            tbRichTextVoiceInfo = Rb;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.gG(sb.length());
                    tbRichTextData.append(spannableString);
                    QT.add(0, tbRichTextData);
                }
            }
            this.hfi = true;
        }
    }

    private com.baidu.tbadk.core.view.e X(boolean z, boolean z2) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        return new com.baidu.tbadk.core.view.e(com.baidu.adp.lib.util.l.h(context, e.C0200e.tbds1), com.baidu.adp.lib.util.l.h(context, e.C0200e.tbds4), this.fKg ? e.d.cp_link_tip_a_alpha50 : e.d.cp_cont_j_alpha50, com.baidu.adp.lib.util.l.h(context, e.C0200e.tbds30), this.fKg ? e.d.cp_link_tip_a : e.d.cp_cont_j, com.baidu.adp.lib.util.l.h(context, e.C0200e.tbds12), com.baidu.adp.lib.util.l.h(context, e.C0200e.tbds42));
    }

    protected Drawable h(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap oq;
        if (aVar == null || (oq = aVar.oq()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(oq);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(e.C0200e.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(e.C0200e.ds36));
        return bitmapDrawable;
    }

    public int bBB() {
        return this.heD;
    }

    public void cU(Context context) {
        int type;
        int i;
        int i2;
        if (this.heB != null) {
            int i3 = -1;
            int size = this.heC.size();
            if (size > 0) {
                try {
                    i3 = this.heC.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.heB.size()) {
                k kVar = this.heB.get(i4);
                if (k.bT(i5, kVar.getType())) {
                    this.heC.get(size - 1).b(kVar.cT(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.heC.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.cT(context));
                        this.heC.add(kVar2);
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

    public void cV(Context context) {
        try {
            if (this.heH != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.heH.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.heC == null || this.heC.size() == 0) {
                cU(context);
            }
            ArrayList<k> arrayList = this.heC;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.bBi() != null) {
                            sb.append((CharSequence) next.bBi());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(e.j.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(e.j.voice_str));
                    } else if (next.getType() == 2) {
                        String hn = TbFaceManager.Mp().hn(next.getText());
                        if (hn != null) {
                            sb.append("[");
                            sb.append(hn);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !ao.isEmpty(next.bBh())) {
                        sb.append("[").append(next.bBh()).append("]");
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
                this.date = ao.E(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.heN = subPostList.is_giftpost.intValue() == 1;
                this.agree = subPostList.agree;
                if (this.agree != null) {
                    this.arK = this.agree.agree_type.intValue();
                    this.hasAgree = this.agree.has_agree.intValue() == 1;
                    this.agreeNum = this.agree.agree_num.longValue() > 0 ? this.agree.agree_num.longValue() : 0L;
                    this.arI = this.agree.disagree_num.longValue() > 0 ? this.agree.disagree_num.longValue() : 0L;
                }
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aqk = metaData;
                }
                if ((this.aqk.getUserId() == null || this.aqk.getUserId().length() <= 0 || this.aqk.getUserId().equals("0")) && metaData2 != null) {
                    this.aqk = metaData2;
                }
                this.heH = TbRichTextView.a(context, subPostList.content, z);
                if (this.heH != null) {
                    this.heH.setPostId(com.baidu.adp.lib.g.b.d(this.id, -1L));
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
                this.date = ao.E(this.time);
                this.fIU = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aqk = metaData;
                }
                this.dIo = post.need_log.intValue() == 1;
                this.heY = post.img_num_abtest.intValue() == 1;
                this.heQ = new ay();
                this.heQ.parserProtobuf(post.from_forum);
                if (this.aqk.getUserId() == null || this.aqk.getUserId().length() <= 0 || this.aqk.getUserId().equals("0")) {
                    this.aqk.parserProtobuf(post.author);
                }
                if (this.aqk != null && context != null) {
                    this.heU = this.aqk.getUserName() + context.getResources().getString(e.j.somebodys_portrait);
                    this.heV = String.format(TbadkCoreApplication.getInst().getString(e.j.degree_in_forum), Integer.valueOf(this.aqk.getLevel_id()));
                }
                this.heK = post.is_ntitle.intValue() == 1;
                this.heD = post.sub_post_number.intValue();
                this.heP = new h(post.tpoint_post);
                this.heH = TbRichTextView.a(context, post.content, true);
                if (this.heH != null) {
                    this.heH.setPostId(com.baidu.adp.lib.g.b.d(this.id, -1L));
                    this.heH.gF(this.floor_num);
                    if (this.aqk != null) {
                        this.heH.setAuthorId(this.aqk.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.heN = subPostList.is_giftpost.intValue() == 1;
                            postData.agree = subPostList.agree;
                            postData.setUserMap(this.userMap);
                            postData.ku(this.fKg);
                            postData.a(subPostList, context);
                            this.heE.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.heJ.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.heL = new com.baidu.tbadk.data.c();
                    this.heL.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.heM = new com.baidu.tbadk.data.f();
                    this.heM.a(post.lbs_info);
                }
                this.aqU = post.storecount.intValue();
                this.heI.a(post.present);
                this.aqx.setUserMap(this.userMap);
                this.aqx.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.gcx = new SmallTailInfo();
                    this.gcx.id = post.signature.signature_id.intValue();
                    this.gcx.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.gcx.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.gcx.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.gcx.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.arh.add(cVar);
                    }
                }
                this.ark = post.skin_info;
                this.arn = post.lego_card;
                this.heW = post.tpoint_post;
                if (post.agree != null) {
                    this.heX = true;
                    this.hasAgree = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.agreeNum = post.agree.agree_num.longValue();
                    } else {
                        this.agreeNum = 0L;
                    }
                    if (post.agree.disagree_num.longValue() >= 0) {
                        this.arI = post.agree.disagree_num.longValue();
                    } else {
                        this.arI = 0L;
                    }
                    this.arK = post.agree.agree_type.intValue();
                } else {
                    this.heX = false;
                }
                if (this.agreeNum < 0) {
                    this.agreeNum = 0L;
                }
                if (this.arI < 0) {
                    this.arI = 0L;
                }
                this.hfd = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.arT = new OriginalThreadInfo();
                    this.arT.parser(post.origin_thread_info);
                } else {
                    this.arT = null;
                }
                this.hfg = post.is_fold.intValue();
                this.fJG = post.fold_tip;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int gaE;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(this.gaE));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> hfo;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.hfo = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(e.d.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.hfo != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.hfo.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String cW(Context context) {
        ArrayList<TbRichTextData> QT;
        if (this.heH == null || (QT = this.heH.QT()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = QT.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.Ra().toString());
            } else if (next.getType() == 17) {
                String str = next.Re().mGifInfo.mSharpText;
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

    public String bBC() {
        ArrayList<TbRichTextData> QT;
        String str;
        if (this.heH == null || (QT = this.heH.QT()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = QT.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.Ra().toString());
                } else if (next.getType() == 17) {
                    if (next.Re() != null && next.Re().mGifInfo != null && (str = next.Re().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo bBD() {
        ArrayList<TbRichTextData> QT;
        if (this.heH != null && (QT = this.heH.QT()) != null) {
            Iterator<TbRichTextData> it = QT.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.QZ().getWidth();
                    preLoadImageInfo.height = next.QZ().getHeight();
                    preLoadImageInfo.imgUrl = next.QZ().Ro();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.Rf().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.Rf().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.Rf().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String bBE() {
        j bBa;
        PreLoadImageInfo bBD = bBD();
        if (bBD != null && !StringUtils.isNull(bBD.imgUrl)) {
            return bBD.imgUrl;
        }
        if (this.heP != null && (bBa = this.heP.bBa()) != null && !StringUtils.isNull(bBa.bBf())) {
            return bBa.bBf();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> QT;
        if (this.heH == null || (QT = this.heH.QT()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = QT.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.QZ().getWidth();
                preLoadImageInfo.height = next.QZ().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.QZ().Rt()) {
                    preLoadImageInfo.imgUrl = next.QZ().Rp();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.QZ().Ro();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.Re() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.Re().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.Re().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.Re();
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
        if (this.aqk == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.aqk.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.heA == 52) {
            return hew;
        }
        if (this.heA == 1) {
            return arl;
        }
        if (this.heA == 36) {
            return heu;
        }
        if (this.heA == 40 || this.heA == 50) {
            return apJ;
        }
        if (this.heA == 41) {
            return hev;
        }
        if (this.heA == 53) {
            return hex;
        }
        if (bBx() == 1) {
            return hes;
        }
        return het;
    }

    public void setPostType(int i) {
        this.heA = i;
    }

    public am bBF() {
        return this.heI;
    }

    public void a(am amVar) {
        this.heI = amVar;
    }

    public h bBG() {
        return this.heP;
    }

    public com.baidu.tbadk.widget.richText.f Rd() {
        if (this.heT != null) {
            return this.heT;
        }
        if (this.heH != null && v.H(this.heH.QT()) > 0) {
            Iterator<TbRichTextData> it = this.heH.QT().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.heT = next.Rd();
                    return this.heT;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo Rb() {
        if (this.aGv != null) {
            return this.aGv;
        }
        if (this.heH != null && v.H(this.heH.QT()) > 0) {
            Iterator<TbRichTextData> it = this.heH.QT().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.aGv = next.Rb();
                    return this.aGv;
                }
            }
        }
        return null;
    }

    public String bBH() {
        return this.heU;
    }

    public String zw() {
        return this.arn;
    }

    public void zz() {
        if (this.aqK == 0) {
            this.aqK = 1;
        }
    }

    public long zO() {
        return this.agreeNum;
    }

    public long zP() {
        return this.arI;
    }

    public void x(long j) {
        this.agreeNum = j;
    }

    public boolean aBr() {
        return this.hasAgree;
    }

    public void cK(int i) {
        this.arK = i;
    }

    public void nt(boolean z) {
        this.hasAgree = z;
    }

    public int zR() {
        return this.arK;
    }

    public void y(long j) {
        this.arI = j;
    }

    public OriginalThreadInfo bBI() {
        return this.arT;
    }

    public void g(OriginalThreadInfo originalThreadInfo) {
        this.arT = originalThreadInfo;
    }

    public int bBJ() {
        return this.hfg;
    }

    public String beB() {
        return this.fJG;
    }
}
