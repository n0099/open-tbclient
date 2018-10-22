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
    private TbRichTextVoiceInfo aFF;
    private Agree agree;
    private String aqA;
    private long aqV;
    private int aqX;
    private SkinInfo aqx;
    private OriginalThreadInfo arg;
    @Deprecated
    private String authorId;
    private String bimg_url;
    private String fHw;
    private boolean fII;
    private SmallTailInfo gbb;
    public int hdC;
    public AlaLiveInfoCoreData hdH;
    private ArrayList<PostData> hdh;
    private com.baidu.tbadk.data.c hdo;
    private com.baidu.tbadk.data.f hdp;
    private h hds;
    private ay hdt;
    public boolean hdv;
    private com.baidu.tbadk.widget.richText.f hdw;
    private String hdx;
    private String hdy;
    private TPointPost hdz;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId hcV = BdUniqueId.gen();
    public static final BdUniqueId hcW = BdUniqueId.gen();
    public static final BdUniqueId aqy = BdUniqueId.gen();
    public static final BdUniqueId hcX = BdUniqueId.gen();
    public static final BdUniqueId aoV = BdUniqueId.gen();
    public static final BdUniqueId hcY = BdUniqueId.gen();
    public static final BdUniqueId hcZ = BdUniqueId.gen();
    public static final BdUniqueId hda = BdUniqueId.gen();
    public static final BdUniqueId hdb = BdUniqueId.gen();
    public static boolean hdc = false;
    private int hdd = 0;
    private boolean hdi = false;
    private ArrayList<PostData> hdj = null;
    private TbRichText hdk = null;
    private boolean hdn = false;
    private boolean hdq = false;
    private boolean hdr = false;
    public boolean hdu = false;
    public int apX = 0;
    private boolean hdA = false;
    private long agreeNum = 0;
    private boolean hasAgree = false;
    public boolean dGT = false;
    public boolean hdB = false;
    public boolean hdD = false;
    public boolean hdE = true;
    public boolean hdF = false;
    public boolean hdG = false;
    private boolean hdI = false;
    private int hdJ = 0;
    private boolean hdK = true;
    public boolean hdL = false;
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData apx = new MetaData();
    private ArrayList<k> hde = new ArrayList<>();
    private ArrayList<k> hdf = new ArrayList<>();
    private int hdg = 0;
    private int aqh = 0;
    private PraiseData apK = new PraiseData();
    private am hdl = new am();
    private c hdm = new c();
    private ArrayList<com.baidu.tbadk.data.c> aqu = new ArrayList<>();

    public PostData() {
        this.hdh = null;
        this.hdC = 0;
        this.hdh = new ArrayList<>();
        this.hdC = 0;
    }

    public void kk(boolean z) {
        this.fII = z;
    }

    public boolean bBT() {
        return this.fII;
    }

    public ArrayList<PostData> bBU() {
        return this.hdj;
    }

    public void bBV() {
        this.hdj.clear();
        this.hdj = null;
        this.hdi = false;
    }

    public void p(PostData postData) {
        if (postData != null) {
            if (this.hdj == null) {
                this.hdj = new ArrayList<>();
                if (v.I(this.hdh) > 2) {
                    this.hdj.addAll(v.b(this.hdh, 0, 2));
                } else {
                    this.hdj.addAll(this.hdh);
                }
            }
            this.hdj.add(postData);
        }
    }

    public void q(PostData postData) {
        if (postData != null && this.hdh != null) {
            this.hdh.add(postData);
            bBZ();
        }
    }

    public void uX(String str) {
        if (this.hdj != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.hdj.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.hdj.remove(next);
                    return;
                }
            }
        }
    }

    public void ne(boolean z) {
        this.hdK = z;
    }

    public boolean bBW() {
        return this.hdK;
    }

    public void nf(boolean z) {
        this.hdi = z;
    }

    public boolean bBX() {
        return this.hdi;
    }

    public ArrayList<PostData> bBY() {
        return this.hdh;
    }

    public void bBZ() {
        this.hdg++;
    }

    public void bCa() {
        this.hdg--;
    }

    public void uF(int i) {
        this.hdg = i;
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

    public String beO() {
        return this.fHw;
    }

    public int bCb() {
        return this.floor_num;
    }

    public void uG(int i) {
        this.floor_num = i;
    }

    public boolean bCc() {
        return this.hdr;
    }

    public void ng(boolean z) {
        this.hdr = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = ao.C(j);
    }

    public MetaData yv() {
        return this.apx;
    }

    public void a(MetaData metaData) {
        this.apx = metaData;
    }

    public void a(PraiseData praiseData) {
        this.apK = praiseData;
    }

    public TbRichText bCd() {
        return this.hdk;
    }

    public void c(TbRichText tbRichText) {
        this.hdk = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo blJ() {
        return this.gbb;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.gbb = smallTailInfo;
    }

    public com.baidu.tbadk.data.f bCe() {
        return this.hdp;
    }

    public SkinInfo yR() {
        return this.aqx;
    }

    public void nh(boolean z) {
        this.hdI = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.hdk != null && this.hdk.QK() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.apx != null && this.apx.getIs_bawu() == 1) {
                    if (this.fII) {
                        str = " 品牌官";
                    } else if ("manager".equals(this.apx.getBawu_type())) {
                        str = " 吧主";
                    } else if ("assist".equals(this.apx.getBawu_type())) {
                        str = " 小吧主";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = yv().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.jC().a(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.f.c.jC().a(next.getIcon(), 21, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.f.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((C02781) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.ot()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.hdk.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004005));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.h(aVar);
                        }
                    }, 0, 1);
                    cVar.d(0, 0, TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(e.C0175e.ds32), TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(e.C0175e.ds32));
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.apx.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.apx.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.apx == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.apx.getName_show() + str + "：");
                str2 = this.apx.getUserName();
                str3 = this.apx.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.apx.getSealPrefix())) {
                Bitmap dm = al.dm(e.f.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(dm);
                if (dm != null) {
                    bitmapDrawable.setBounds(0, 0, dm.getWidth(), dm.getHeight());
                }
                com.baidu.tbadk.core.view.m mVar = new com.baidu.tbadk.core.view.m(bitmapDrawable);
                mVar.setOffset(com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), e.C0175e.ds2));
                int size = arrayList.size() + this.apx.getSealPrefix().length() + 1;
                spannableString.setSpan(mVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.apx != null && this.apx.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.e V = V(z, this.apx != null && this.apx.getIs_bawu() == 1);
                if (V != null) {
                    if (this.apx != null) {
                        int i3 = 0;
                        if (this.apx.getName_show() != null) {
                            i3 = this.apx.getName_show().length();
                        }
                        spannableString.setSpan(V, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(V, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> QK = this.hdk.QK();
            if (QK != null && QK.size() > 0) {
                TbRichTextData tbRichTextData2 = QK.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.QR() != null) {
                    if (this.hdI) {
                        int indexOf = tbRichTextData2.QR().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.QR().delete(0, indexOf + 1);
                        }
                        this.hdI = false;
                    }
                    tbRichTextData2.gs(sb.length());
                    tbRichTextData2.QR().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= QK.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (QK.get(i5) == null || QK.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo QS = QK.get(i5).QS();
                            QK.remove(i5);
                            tbRichTextVoiceInfo = QS;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.gs(sb.length());
                    tbRichTextData.append(spannableString);
                    QK.add(0, tbRichTextData);
                }
            }
            this.hdL = true;
        }
    }

    private com.baidu.tbadk.core.view.e V(boolean z, boolean z2) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        return new com.baidu.tbadk.core.view.e(com.baidu.adp.lib.util.l.h(context, e.C0175e.tbds1), com.baidu.adp.lib.util.l.h(context, e.C0175e.tbds4), this.fII ? e.d.cp_link_tip_a_alpha50 : e.d.cp_cont_j_alpha50, com.baidu.adp.lib.util.l.h(context, e.C0175e.tbds30), this.fII ? e.d.cp_link_tip_a : e.d.cp_cont_j, com.baidu.adp.lib.util.l.h(context, e.C0175e.tbds12), com.baidu.adp.lib.util.l.h(context, e.C0175e.tbds42));
    }

    protected Drawable h(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap os;
        if (aVar == null || (os = aVar.os()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(os);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(e.C0175e.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(e.C0175e.ds36));
        return bitmapDrawable;
    }

    public int bCf() {
        return this.hdg;
    }

    public void cZ(Context context) {
        int type;
        int i;
        int i2;
        if (this.hde != null) {
            int i3 = -1;
            int size = this.hdf.size();
            if (size > 0) {
                try {
                    i3 = this.hdf.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.hde.size()) {
                k kVar = this.hde.get(i4);
                if (k.bP(i5, kVar.getType())) {
                    this.hdf.get(size - 1).b(kVar.cY(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.hdf.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.cY(context));
                        this.hdf.add(kVar2);
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

    public void da(Context context) {
        try {
            if (this.hdk != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.hdk.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.hdf == null || this.hdf.size() == 0) {
                cZ(context);
            }
            ArrayList<k> arrayList = this.hdf;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.bBM() != null) {
                            sb.append((CharSequence) next.bBM());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(e.j.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(e.j.voice_str));
                    } else if (next.getType() == 2) {
                        String hm = TbFaceManager.Md().hm(next.getText());
                        if (hm != null) {
                            sb.append("[");
                            sb.append(hm);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !ao.isEmpty(next.bBL())) {
                        sb.append("[").append(next.bBL()).append("]");
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
                this.date = ao.C(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.hdq = subPostList.is_giftpost.intValue() == 1;
                this.agree = subPostList.agree;
                if (this.agree != null) {
                    this.aqX = this.agree.agree_type.intValue();
                    this.hasAgree = this.agree.has_agree.intValue() == 1;
                    this.agreeNum = this.agree.agree_num.longValue() > 0 ? this.agree.agree_num.longValue() : 0L;
                    this.aqV = this.agree.disagree_num.longValue() > 0 ? this.agree.disagree_num.longValue() : 0L;
                }
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.apx = metaData;
                }
                if ((this.apx.getUserId() == null || this.apx.getUserId().length() <= 0 || this.apx.getUserId().equals("0")) && metaData2 != null) {
                    this.apx = metaData2;
                }
                this.hdk = TbRichTextView.a(context, subPostList.content, z);
                if (this.hdk != null) {
                    this.hdk.setPostId(com.baidu.adp.lib.g.b.d(this.id, -1L));
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
                this.date = ao.C(this.time);
                this.fHw = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.apx = metaData;
                }
                this.dGT = post.need_log.intValue() == 1;
                this.hdB = post.img_num_abtest.intValue() == 1;
                this.hdt = new ay();
                this.hdt.parserProtobuf(post.from_forum);
                if (this.apx.getUserId() == null || this.apx.getUserId().length() <= 0 || this.apx.getUserId().equals("0")) {
                    this.apx.parserProtobuf(post.author);
                }
                if (this.apx != null && context != null) {
                    this.hdx = this.apx.getUserName() + context.getResources().getString(e.j.somebodys_portrait);
                    this.hdy = String.format(TbadkCoreApplication.getInst().getString(e.j.degree_in_forum), Integer.valueOf(this.apx.getLevel_id()));
                }
                this.hdn = post.is_ntitle.intValue() == 1;
                this.hdg = post.sub_post_number.intValue();
                this.hds = new h(post.tpoint_post);
                this.hdk = TbRichTextView.a(context, post.content, true);
                if (this.hdk != null) {
                    this.hdk.setPostId(com.baidu.adp.lib.g.b.d(this.id, -1L));
                    this.hdk.gr(this.floor_num);
                    if (this.apx != null) {
                        this.hdk.setAuthorId(this.apx.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.hdq = subPostList.is_giftpost.intValue() == 1;
                            postData.agree = subPostList.agree;
                            postData.setUserMap(this.userMap);
                            postData.kk(this.fII);
                            postData.a(subPostList, context);
                            this.hdh.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.hdm.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.hdo = new com.baidu.tbadk.data.c();
                    this.hdo.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.hdp = new com.baidu.tbadk.data.f();
                    this.hdp.a(post.lbs_info);
                }
                this.aqh = post.storecount.intValue();
                this.hdl.a(post.present);
                this.apK.setUserMap(this.userMap);
                this.apK.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.gbb = new SmallTailInfo();
                    this.gbb.id = post.signature.signature_id.intValue();
                    this.gbb.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.gbb.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.gbb.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.gbb.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.aqu.add(cVar);
                    }
                }
                this.aqx = post.skin_info;
                this.aqA = post.lego_card;
                this.hdz = post.tpoint_post;
                if (post.agree != null) {
                    this.hdA = true;
                    this.hasAgree = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.agreeNum = post.agree.agree_num.longValue();
                    } else {
                        this.agreeNum = 0L;
                    }
                    if (post.agree.disagree_num.longValue() >= 0) {
                        this.aqV = post.agree.disagree_num.longValue();
                    } else {
                        this.aqV = 0L;
                    }
                    this.aqX = post.agree.agree_type.intValue();
                } else {
                    this.hdA = false;
                }
                if (this.agreeNum < 0) {
                    this.agreeNum = 0L;
                }
                if (this.aqV < 0) {
                    this.aqV = 0L;
                }
                this.hdG = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.arg = new OriginalThreadInfo();
                    this.arg.parser(post.origin_thread_info);
                } else {
                    this.arg = null;
                }
                this.hdJ = post.is_fold.intValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int fZi;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(this.fZi));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> hdR;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.hdR = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(e.d.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.hdR != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.hdR.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String db(Context context) {
        ArrayList<TbRichTextData> QK;
        if (this.hdk == null || (QK = this.hdk.QK()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = QK.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.QR().toString());
            } else if (next.getType() == 17) {
                String str = next.QV().mGifInfo.mSharpText;
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

    public String bCg() {
        ArrayList<TbRichTextData> QK;
        String str;
        if (this.hdk == null || (QK = this.hdk.QK()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = QK.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.QR().toString());
                } else if (next.getType() == 17) {
                    if (next.QV() != null && next.QV().mGifInfo != null && (str = next.QV().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo bCh() {
        ArrayList<TbRichTextData> QK;
        if (this.hdk != null && (QK = this.hdk.QK()) != null) {
            Iterator<TbRichTextData> it = QK.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.QQ().getWidth();
                    preLoadImageInfo.height = next.QQ().getHeight();
                    preLoadImageInfo.imgUrl = next.QQ().Rf();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.QW().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.QW().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.QW().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String bCi() {
        j bBE;
        PreLoadImageInfo bCh = bCh();
        if (bCh != null && !StringUtils.isNull(bCh.imgUrl)) {
            return bCh.imgUrl;
        }
        if (this.hds != null && (bBE = this.hds.bBE()) != null && !StringUtils.isNull(bBE.bBJ())) {
            return bBE.bBJ();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> QK;
        if (this.hdk == null || (QK = this.hdk.QK()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = QK.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.QQ().getWidth();
                preLoadImageInfo.height = next.QQ().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.QQ().Rk()) {
                    preLoadImageInfo.imgUrl = next.QQ().Rg();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.QQ().Rf();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.QV() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.QV().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.QV().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.QV();
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
        if (this.apx == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.apx.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.hdd == 52) {
            return hcZ;
        }
        if (this.hdd == 1) {
            return aqy;
        }
        if (this.hdd == 36) {
            return hcX;
        }
        if (this.hdd == 40 || this.hdd == 50) {
            return aoV;
        }
        if (this.hdd == 41) {
            return hcY;
        }
        if (this.hdd == 53) {
            return hda;
        }
        if (bCb() == 1) {
            return hcV;
        }
        return hcW;
    }

    public void setPostType(int i) {
        this.hdd = i;
    }

    public am bCj() {
        return this.hdl;
    }

    public void a(am amVar) {
        this.hdl = amVar;
    }

    public h bCk() {
        return this.hds;
    }

    public com.baidu.tbadk.widget.richText.f QU() {
        if (this.hdw != null) {
            return this.hdw;
        }
        if (this.hdk != null && v.I(this.hdk.QK()) > 0) {
            Iterator<TbRichTextData> it = this.hdk.QK().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.hdw = next.QU();
                    return this.hdw;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo QS() {
        if (this.aFF != null) {
            return this.aFF;
        }
        if (this.hdk != null && v.I(this.hdk.QK()) > 0) {
            Iterator<TbRichTextData> it = this.hdk.QK().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.aFF = next.QS();
                    return this.aFF;
                }
            }
        }
        return null;
    }

    public String bCl() {
        return this.hdx;
    }

    public String zp() {
        return this.aqA;
    }

    public void zs() {
        if (this.apX == 0) {
            this.apX = 1;
        }
    }

    public long zH() {
        return this.agreeNum;
    }

    public long zI() {
        return this.aqV;
    }

    public void v(long j) {
        this.agreeNum = j;
    }

    public boolean aBU() {
        return this.hasAgree;
    }

    public void cw(int i) {
        this.aqX = i;
    }

    public void ni(boolean z) {
        this.hasAgree = z;
    }

    public int zK() {
        return this.aqX;
    }

    public void w(long j) {
        this.aqV = j;
    }

    public OriginalThreadInfo bCm() {
        return this.arg;
    }

    public void g(OriginalThreadInfo originalThreadInfo) {
        this.arg = originalThreadInfo;
    }

    public int bCn() {
        return this.hdJ;
    }
}
