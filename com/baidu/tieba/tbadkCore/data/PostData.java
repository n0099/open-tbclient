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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
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
public class PostData implements com.baidu.adp.widget.ListView.i, ae {
    private SkinInfo aOu;
    private String aOx;
    private OriginalThreadInfo aPb;
    @Deprecated
    private String authorId;
    private TbRichTextVoiceInfo bcn;
    private String bimg_url;
    private String fBD;
    private SmallTailInfo fVV;
    private ArrayList<PostData> hiS;
    private com.baidu.tbadk.data.c hiZ;
    private com.baidu.tbadk.data.f hja;
    private h hjd;
    private az hje;
    public boolean hjg;
    private com.baidu.tbadk.widget.richText.f hjh;
    private String hji;
    private String hjj;
    private TPointPost hjk;
    public int hjo;
    public AlaLiveInfoCoreData hjt;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId hiF = BdUniqueId.gen();
    public static final BdUniqueId hiG = BdUniqueId.gen();
    public static final BdUniqueId hiH = BdUniqueId.gen();
    public static final BdUniqueId aOv = BdUniqueId.gen();
    public static final BdUniqueId hiI = BdUniqueId.gen();
    public static final BdUniqueId aNf = BdUniqueId.gen();
    public static final BdUniqueId hiJ = BdUniqueId.gen();
    public static final BdUniqueId hiK = BdUniqueId.gen();
    public static final BdUniqueId hiL = BdUniqueId.gen();
    public static final BdUniqueId hiM = BdUniqueId.gen();
    public static boolean hiN = false;
    private int hiO = 0;
    private boolean hiT = false;
    private ArrayList<PostData> hiU = null;
    private TbRichText hiV = null;
    private boolean hiY = false;
    private boolean hjb = false;
    private boolean hjc = false;
    public boolean hjf = false;
    public int aNW = 0;
    private boolean hjl = false;
    private long dAQ = 0;
    private boolean dAS = false;
    public boolean hjm = false;
    public boolean hjn = false;
    public boolean hjp = false;
    public boolean hjq = true;
    public boolean hjr = false;
    public boolean hjs = false;
    private boolean hju = false;
    private int hjv = 0;
    private boolean hjw = true;
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData aNy = new MetaData();
    private ArrayList<k> hiP = new ArrayList<>();
    private ArrayList<k> hiQ = new ArrayList<>();
    private int hiR = 0;
    private int aOg = 0;
    private PraiseData aNK = new PraiseData();
    private an hiW = new an();
    private c hiX = new c();
    private ArrayList<com.baidu.tbadk.data.c> aOs = new ArrayList<>();

    public PostData() {
        this.hiS = null;
        this.hjo = 0;
        this.hiS = new ArrayList<>();
        this.hjo = 0;
    }

    public ArrayList<PostData> bCd() {
        return this.hiU;
    }

    public void bCe() {
        this.hiU.clear();
        this.hiU = null;
        this.hiT = false;
    }

    public void y(PostData postData) {
        if (postData != null) {
            if (this.hiU == null) {
                this.hiU = new ArrayList<>();
                if (v.F(this.hiS) > 2) {
                    this.hiU.addAll(v.b(this.hiS, 0, 2));
                } else {
                    this.hiU.addAll(this.hiS);
                }
            }
            this.hiU.add(postData);
        }
    }

    public void z(PostData postData) {
        if (postData != null && this.hiS != null) {
            this.hiS.add(postData);
            bCj();
        }
    }

    public void td(String str) {
        if (this.hiU != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.hiU.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.hiU.remove(next);
                    return;
                }
            }
        }
    }

    public void nu(boolean z) {
        this.hjw = z;
    }

    public boolean bCf() {
        return this.hjw;
    }

    public void nv(boolean z) {
        this.hiT = z;
    }

    public boolean bCg() {
        return this.hiT;
    }

    public c bCh() {
        return this.hiX;
    }

    public ArrayList<PostData> bCi() {
        return this.hiS;
    }

    public void bCj() {
        this.hiR++;
    }

    public void bCk() {
        this.hiR--;
    }

    public void xi(int i) {
        this.hiR = i;
    }

    public boolean isGiftPost() {
        return this.hjb;
    }

    public void setIsGiftPost(boolean z) {
        this.hjb = z;
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

    public String aYn() {
        return this.fBD;
    }

    public int bCl() {
        return this.floor_num;
    }

    public void xj(int i) {
        this.floor_num = i;
    }

    public boolean bCm() {
        return this.hjc;
    }

    public void nw(boolean z) {
        this.hjc = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = am.z(j);
    }

    public String bCn() {
        return this.date;
    }

    public MetaData yX() {
        return this.aNy;
    }

    public void a(MetaData metaData) {
        this.aNy = metaData;
    }

    public void a(PraiseData praiseData) {
        this.aNK = praiseData;
    }

    public TbRichText bCo() {
        return this.hiV;
    }

    public void d(TbRichText tbRichText) {
        this.hiV = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo bfu() {
        return this.fVV;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.fVV = smallTailInfo;
    }

    public com.baidu.tbadk.data.f bCp() {
        return this.hja;
    }

    public SkinInfo zt() {
        return this.aOu;
    }

    public void nx(boolean z) {
        this.hju = z;
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.hiV != null && this.hiV.QN() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else if (this.aNy != null && this.aNy.getIs_bawu() == 1 && "manager".equals(this.aNy.getBawu_type())) {
                str = " 吧主";
            } else if (this.aNy == null || this.aNy.getIs_bawu() != 1 || !"assist".equals(this.aNy.getBawu_type())) {
                str = "";
            } else {
                str = " 小吧";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = yX().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.nl().a(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.f.c.nl().a(next.getIcon(), 21, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.f.b
                                    public void onLoaded(com.baidu.adp.widget.a.a aVar2, String str4, int i) {
                                        super.onLoaded((C01561) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.sj()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.hiV.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.h(aVar);
                        }
                    }, 0, 1);
                    cVar.k(0, 0, TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.e.ds32), TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.e.ds32));
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.aNy.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.aNy.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.aNy == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.aNy.getName_show() + str + "：");
                str2 = this.aNy.getUserName();
                str3 = this.aNy.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.aNy.getSealPrefix())) {
                Bitmap fQ = aj.fQ(d.f.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(fQ);
                if (fQ != null) {
                    bitmapDrawable.setBounds(0, 0, fQ.getWidth(), fQ.getHeight());
                }
                com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable);
                kVar.setOffset(com.baidu.adp.lib.util.l.s(tbPageContext.getPageActivity(), d.e.ds2));
                int size = arrayList.size() + this.aNy.getSealPrefix().length() + 1;
                spannableString.setSpan(kVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.aNy != null && this.aNy.getIs_bawu() == 1))) {
                CustomForegroundColorSpan customForegroundColorSpan = new CustomForegroundColorSpan(d.C0108d.cp_link_tip_a);
                if (this.aNy != null) {
                    spannableString.setSpan(customForegroundColorSpan, sb2.length() + this.aNy.getName_show().length() + 1, str.length() + sb2.length() + this.aNy.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(customForegroundColorSpan, sb2.length(), str.length() + sb2.length(), 17);
                }
            }
            ArrayList<TbRichTextData> QN = this.hiV.QN();
            if (QN != null && QN.size() > 0) {
                TbRichTextData tbRichTextData2 = QN.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.QU() != null) {
                    if (this.hju) {
                        int indexOf = tbRichTextData2.QU().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.QU().delete(0, indexOf + 1);
                        }
                        this.hju = false;
                    }
                    tbRichTextData2.jb(sb.length());
                    tbRichTextData2.QU().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= QN.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (QN.get(i4) == null || QN.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        TbRichTextVoiceInfo QV = QN.get(i4).QV();
                        QN.remove(i4);
                        tbRichTextVoiceInfo = QV;
                        break;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.a(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.jb(sb.length());
                tbRichTextData.append(spannableString);
                QN.add(0, tbRichTextData);
            }
        }
    }

    protected Drawable h(com.baidu.adp.widget.a.a aVar) {
        Bitmap si;
        if (aVar == null || (si = aVar.si()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(si);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.e.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.e.ds36));
        return bitmapDrawable;
    }

    public int bCq() {
        return this.hiR;
    }

    public void cn(Context context) {
        int type;
        int i;
        int i2;
        if (this.hiP != null) {
            int i3 = -1;
            int size = this.hiQ.size();
            if (size > 0) {
                try {
                    i3 = this.hiQ.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.hiP.size()) {
                k kVar = this.hiP.get(i4);
                if (k.cT(i5, kVar.getType())) {
                    this.hiQ.get(size - 1).b(kVar.cm(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.hiQ.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.cm(context));
                        this.hiQ.add(kVar2);
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

    public void co(Context context) {
        try {
            if (this.hiV != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.hiV.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.hiQ == null || this.hiQ.size() == 0) {
                cn(context);
            }
            ArrayList<k> arrayList = this.hiQ;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.bBW() != null) {
                            sb.append((CharSequence) next.bBW());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(d.j.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(d.j.voice_str));
                    } else if (next.getType() == 2) {
                        String fU = TbFaceManager.Ma().fU(next.getText());
                        if (fU != null) {
                            sb.append("[");
                            sb.append(fU);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !am.isEmpty(next.bBV())) {
                        sb.append("[").append(next.bBV()).append("]");
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
                this.date = am.z(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.hjb = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aNy = metaData;
                }
                if ((this.aNy.getUserId() == null || this.aNy.getUserId().length() <= 0 || this.aNy.getUserId().equals("0")) && metaData2 != null) {
                    this.aNy = metaData2;
                }
                this.hiV = TbRichTextView.a(context, subPostList.content, z);
                if (this.hiV != null) {
                    this.hiV.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
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
                this.date = am.z(this.time);
                this.fBD = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aNy = metaData;
                }
                this.hjm = post.need_log.intValue() == 1;
                this.hjn = post.img_num_abtest.intValue() == 1;
                this.hje = new az();
                this.hje.parserProtobuf(post.from_forum);
                if (this.aNy.getUserId() == null || this.aNy.getUserId().length() <= 0 || this.aNy.getUserId().equals("0")) {
                    this.aNy.parserProtobuf(post.author);
                }
                if (this.aNy != null && context != null) {
                    this.hji = this.aNy.getUserName() + context.getResources().getString(d.j.somebodys_portrait);
                    this.hjj = String.format(TbadkCoreApplication.getInst().getString(d.j.degree_in_forum), Integer.valueOf(this.aNy.getLevel_id()));
                }
                this.hiY = post.is_ntitle.intValue() == 1;
                this.hiR = post.sub_post_number.intValue();
                this.hjd = new h(post.tpoint_post);
                this.hiV = TbRichTextView.a(context, post.content, true);
                if (this.hiV != null) {
                    this.hiV.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.hiV.ja(this.floor_num);
                    if (this.aNy != null) {
                        this.hiV.setAuthorId(this.aNy.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.hjb = subPostList.is_giftpost.intValue() == 1;
                            postData.setUserMap(this.userMap);
                            postData.a(subPostList, context);
                            this.hiS.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.hiX.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.hiZ = new com.baidu.tbadk.data.c();
                    this.hiZ.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.hja = new com.baidu.tbadk.data.f();
                    this.hja.a(post.lbs_info);
                }
                this.aOg = post.storecount.intValue();
                this.hiW.a(post.present);
                this.aNK.setUserMap(this.userMap);
                this.aNK.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.fVV = new SmallTailInfo();
                    this.fVV.id = post.signature.signature_id.intValue();
                    this.fVV.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.fVV.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.fVV.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.fVV.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.aOs.add(cVar);
                    }
                }
                this.aOu = post.skin_info;
                this.aOx = post.lego_card;
                this.hjk = post.tpoint_post;
                if (post.agree != null) {
                    this.hjl = true;
                    this.dAS = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.dAQ = post.agree.agree_num.longValue();
                    } else {
                        this.dAQ = 0L;
                    }
                } else {
                    this.hjl = false;
                }
                this.hjs = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.aPb = new OriginalThreadInfo();
                    this.aPb.parser(post.origin_thread_info);
                } else {
                    this.aPb = null;
                }
                this.hjv = post.is_fold.intValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int fUl;

        public CustomForegroundColorSpan(int i) {
            super(aj.getColor(i));
            this.fUl = i;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aj.getColor(this.fUl));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> hjC;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.hjC = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aj.getColor(d.C0108d.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.hjC != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.hjC.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String cp(Context context) {
        ArrayList<TbRichTextData> QN;
        if (this.hiV == null || (QN = this.hiV.QN()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = QN.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.QU().toString());
            } else if (next.getType() == 17) {
                String str = next.QY().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(d.j.editor_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(d.j.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(d.j.video_title_str) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public String bCr() {
        ArrayList<TbRichTextData> QN;
        String str;
        if (this.hiV == null || (QN = this.hiV.QN()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = QN.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.QU().toString());
                } else if (next.getType() == 17) {
                    if (next.QY() != null && next.QY().mGifInfo != null && (str = next.QY().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo bCs() {
        ArrayList<TbRichTextData> QN;
        if (this.hiV != null && (QN = this.hiV.QN()) != null) {
            Iterator<TbRichTextData> it = QN.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.QT().getWidth();
                    preLoadImageInfo.height = next.QT().getHeight();
                    preLoadImageInfo.imgUrl = next.QT().Rh();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                }
            }
            return null;
        }
        return null;
    }

    public String bCt() {
        j bBO;
        PreLoadImageInfo bCs = bCs();
        if (bCs != null && !StringUtils.isNull(bCs.imgUrl)) {
            return bCs.imgUrl;
        }
        if (this.hjd != null && (bBO = this.hjd.bBO()) != null && !StringUtils.isNull(bBO.bBT())) {
            return bBO.bBT();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> QN;
        if (this.hiV == null || (QN = this.hiV.QN()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = QN.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.QT().getWidth();
                preLoadImageInfo.height = next.QT().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.QT().Rm()) {
                    preLoadImageInfo.imgUrl = next.QT().Ri();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.QT().Rh();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.QY() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.QY().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.QY().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.QY();
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
        if (this.aNy == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.aNy.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (this.hiO == 52) {
            return hiL;
        }
        if (this.hiO == 2) {
            return hiH;
        }
        if (this.hiO == 1) {
            return aOv;
        }
        if (this.hiO == 36) {
            return hiI;
        }
        if (this.hiO == 40 || this.hiO == 50) {
            return aNf;
        }
        if (this.hiO == 41) {
            return hiJ;
        }
        if (this.hiO == 53) {
            return hiM;
        }
        if (bCl() == 1) {
            return hiF;
        }
        return hiG;
    }

    public void setPostType(int i) {
        this.hiO = i;
    }

    public an bCu() {
        return this.hiW;
    }

    public void a(an anVar) {
        this.hiW = anVar;
    }

    public h bCv() {
        return this.hjd;
    }

    public com.baidu.tbadk.widget.richText.f QX() {
        if (this.hjh != null) {
            return this.hjh;
        }
        if (this.hiV != null && v.F(this.hiV.QN()) > 0) {
            Iterator<TbRichTextData> it = this.hiV.QN().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.hjh = next.QX();
                    return this.hjh;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo QV() {
        if (this.bcn != null) {
            return this.bcn;
        }
        if (this.hiV != null && v.F(this.hiV.QN()) > 0) {
            Iterator<TbRichTextData> it = this.hiV.QN().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.bcn = next.QV();
                    return this.bcn;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.tbadk.data.c> bCw() {
        return this.aOs;
    }

    public String bCx() {
        return this.hji;
    }

    public String bCy() {
        return this.hjj;
    }

    public String zT() {
        return this.aOx;
    }

    public void zW() {
        if (this.aNW == 0) {
            this.aNW = 1;
        }
    }

    public long bCz() {
        return this.dAQ;
    }

    public void cX(long j) {
        this.dAQ = j;
    }

    public boolean bCA() {
        return this.dAS;
    }

    public void ny(boolean z) {
        this.dAS = z;
    }

    public OriginalThreadInfo bCB() {
        return this.aPb;
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        this.aPb = originalThreadInfo;
    }

    public int bCC() {
        return this.hjv;
    }
}
