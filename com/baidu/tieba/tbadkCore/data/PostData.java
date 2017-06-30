package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.w;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ActPost;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes.dex */
public class PostData implements v, aj {
    private SkinInfo YD;
    private String YG;
    private TbRichTextVoiceInfo anc;
    @Deprecated
    private String authorId;
    private String bimg_url;
    private SmallTailInfo eIP;
    private String erc;
    private com.baidu.tbadk.data.g fMA;
    private h fMD;
    private bf fME;
    private com.baidu.tbadk.widget.richText.e fMF;
    private String fMG;
    private String fMH;
    private TPointPost fMJ;
    public int fMO;
    private ArrayList<PostData> fMt;
    private com.baidu.tbadk.data.b fMz;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId fMf = BdUniqueId.gen();
    public static final BdUniqueId fMg = BdUniqueId.gen();
    public static final BdUniqueId fMh = BdUniqueId.gen();
    public static final BdUniqueId YE = BdUniqueId.gen();
    public static final BdUniqueId fMi = BdUniqueId.gen();
    public static final BdUniqueId Xr = BdUniqueId.gen();
    public static final BdUniqueId fMj = BdUniqueId.gen();
    public static final BdUniqueId fMk = BdUniqueId.gen();
    public static final BdUniqueId fMl = BdUniqueId.gen();
    public static final BdUniqueId fMm = BdUniqueId.gen();
    public static final BdUniqueId fMn = BdUniqueId.gen();
    public static final BdUniqueId erY = BdUniqueId.gen();
    public static final BdUniqueId fMo = BdUniqueId.gen();
    public static final BdUniqueId fMp = BdUniqueId.gen();
    public static boolean fMq = false;
    private int fMr = 0;
    private boolean fMu = false;
    private ArrayList<PostData> fMv = null;
    private TbRichText dyV = null;
    private boolean fMy = false;
    private boolean fMB = false;
    private boolean fMC = false;
    public int Yf = 0;
    public boolean fMI = false;
    private boolean fMK = false;
    private long fML = 0;
    private boolean fMM = false;
    public boolean fMN = false;
    public boolean fMP = false;
    public boolean fMQ = true;
    public boolean cls = false;
    public boolean fMR = false;
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData author = new MetaData();
    private ArrayList<k> dvP = new ArrayList<>();
    private ArrayList<k> dwF = new ArrayList<>();
    private int fMs = 0;
    private int Yp = 0;
    private PraiseData XS = new PraiseData();
    private at fMw = new at();
    private c fMx = new c();
    private ArrayList<com.baidu.tbadk.data.b> YB = new ArrayList<>();

    public PostData() {
        this.fMt = null;
        this.fMO = 0;
        this.fMt = new ArrayList<>();
        this.fMO = 0;
    }

    public ArrayList<PostData> bmo() {
        return this.fMv;
    }

    public void y(PostData postData) {
        if (postData != null) {
            if (this.fMv == null) {
                this.fMv = new ArrayList<>();
                if (z.s(this.fMt) > 2) {
                    this.fMv.addAll(z.a(this.fMt, 0, 2));
                } else {
                    this.fMv.addAll(this.fMt);
                }
            }
            this.fMv.add(postData);
        }
    }

    public void z(PostData postData) {
        if (postData != null && this.fMt != null) {
            this.fMt.add(postData);
            bms();
        }
    }

    public void rk(String str) {
        if (this.fMv != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.fMv.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.fMv.remove(next);
                    return;
                }
            }
        }
    }

    public void lQ(boolean z) {
        this.fMu = z;
    }

    public boolean bmp() {
        return this.fMu;
    }

    public c bmq() {
        return this.fMx;
    }

    public ArrayList<PostData> bmr() {
        return this.fMt;
    }

    public void bms() {
        this.fMs++;
    }

    public void bmt() {
        this.fMs--;
    }

    public void sE(int i) {
        this.fMs = i;
    }

    public boolean isGiftPost() {
        return this.fMB;
    }

    public void setIsGiftPost(boolean z) {
        this.fMB = z;
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

    public String aMh() {
        return this.erc;
    }

    public int bmu() {
        return this.floor_num;
    }

    public void sF(int i) {
        this.floor_num = i;
    }

    public boolean bmv() {
        return this.fMC;
    }

    public void lR(boolean z) {
        this.fMC = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = aw.q(j);
    }

    public String bmw() {
        return this.date;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public void a(PraiseData praiseData) {
        this.XS = praiseData;
    }

    public TbRichText azb() {
        return this.dyV;
    }

    public void g(TbRichText tbRichText) {
        this.dyV = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo aSA() {
        return this.eIP;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.eIP = smallTailInfo;
    }

    public com.baidu.tbadk.data.g bmx() {
        return this.fMA;
    }

    public SkinInfo rM() {
        return this.YD;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.dyV != null && this.dyV.HU() != null) {
            BdUniqueId uniqueId = tbPageContext.getUniqueId();
            String str3 = z ? " 楼主" : "";
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = getAuthor().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.e eVar = new com.baidu.adp.widget.e(new p(this, it.next(), uniqueId), 0, 1);
                    eVar.d(0, 0, TbadkCoreApplication.m9getInst().getApp().getResources().getDimensionPixelSize(w.f.ds32), TbadkCoreApplication.m9getInst().getApp().getResources().getDimensionPixelSize(w.f.ds32));
                    arrayList.add(eVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.author.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.author.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.author == null) {
                str = null;
                spannableString = new SpannableString(String.valueOf(sb2) + str3 + "：");
                str2 = null;
            } else {
                spannableString = new SpannableString(String.valueOf(sb2) + this.author.getName_show() + str3 + "：");
                str = this.author.getUserName();
                str2 = this.author.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.author.getSealPrefix())) {
                Bitmap cO = as.cO(w.g.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cO);
                if (cO != null) {
                    bitmapDrawable.setBounds(0, 0, cO.getWidth(), cO.getHeight());
                }
                com.baidu.tbadk.core.view.as asVar = new com.baidu.tbadk.core.view.as(bitmapDrawable);
                asVar.setOffset(com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds2));
                int size = arrayList.size() + this.author.getSealPrefix().length() + 1;
                spannableString.setSpan(asVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str, str2), 0, spannableString.length(), 18);
            if (z) {
                AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds28));
                CustomForegroundColorSpan customForegroundColorSpan = new CustomForegroundColorSpan(w.e.cp_link_tip_a);
                if (this.author != null) {
                    spannableString.setSpan(absoluteSizeSpan, sb2.length() + this.author.getName_show().length() + 1, sb2.length() + this.author.getName_show().length() + str3.length(), 17);
                    spannableString.setSpan(customForegroundColorSpan, sb2.length() + this.author.getName_show().length() + 1, str3.length() + sb2.length() + this.author.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(absoluteSizeSpan, sb2.length(), sb2.length() + str3.length(), 17);
                    spannableString.setSpan(customForegroundColorSpan, sb2.length(), str3.length() + sb2.length(), 17);
                }
            }
            ArrayList<TbRichTextData> HU = this.dyV.HU();
            if (HU != null && HU.size() > 0) {
                TbRichTextData tbRichTextData2 = HU.get(0);
                if (tbRichTextData2.Ib() != null) {
                    tbRichTextData2.ft(sb.length());
                    tbRichTextData2.Ib().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= HU.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (HU.get(i4) == null || HU.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        TbRichTextVoiceInfo Ic = HU.get(i4).Ic();
                        HU.remove(i4);
                        tbRichTextVoiceInfo = Ic;
                        break;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.a(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.ft(sb.length());
                tbRichTextData.append(spannableString);
                HU.add(0, tbRichTextData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable g(com.baidu.adp.widget.a.a aVar) {
        Bitmap kP;
        if (aVar == null || (kP = aVar.kP()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(kP);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(w.f.ds36), TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(w.f.ds36));
        return bitmapDrawable;
    }

    public int bmy() {
        return this.fMs;
    }

    public void bM(Context context) {
        int type;
        int i;
        int i2;
        if (this.dvP != null) {
            int i3 = -1;
            int size = this.dwF.size();
            if (size > 0) {
                try {
                    i3 = this.dwF.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.dvP.size()) {
                k kVar = this.dvP.get(i4);
                if (k.bv(i5, kVar.getType())) {
                    this.dwF.get(size - 1).b(kVar.bL(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.dwF.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.bL(context));
                        this.dwF.add(kVar2);
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

    public void bN(Context context) {
        try {
            if (this.dyV != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.dyV.toString());
                clipboardManager.getText();
                return;
            }
            if (this.dwF == null || this.dwF.size() == 0) {
                bM(context);
            }
            ArrayList<k> arrayList = this.dwF;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.bmg() != null) {
                            sb.append((CharSequence) next.bmg());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(w.l.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(w.l.voice_str));
                    } else if (next.getType() == 2) {
                        String fz = TbFaceManager.Ea().fz(next.getText());
                        if (fz != null) {
                            sb.append("[");
                            sb.append(fz);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !aw.isEmpty(next.bmf())) {
                        sb.append("[").append(next.bmf()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                clipboardManager2.getText();
            }
        } catch (NullPointerException e) {
            BdLog.detailException(e);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        a(jSONObject, (Context) null);
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
                this.date = aw.q(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.fMB = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.dyV = TbRichTextView.b(context, subPostList.content, z);
                if (this.dyV != null) {
                    this.dyV.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(JSONObject jSONObject, Context context) {
        MetaData metaData;
        if (jSONObject != null) {
            try {
                this.id = jSONObject.optString("id");
                this.title = jSONObject.optString(VrPlayerActivityConfig.TITLE);
                this.floor_num = jSONObject.optInt("floor", 0);
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.date = aw.q(this.time);
                this.erc = jSONObject.optString("time_ex");
                MetaData metaData2 = new MetaData();
                metaData2.parserJson(jSONObject.optJSONObject("author"));
                this.authorId = jSONObject.optString("author_id");
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                this.fME = new bf();
                this.fME.parserJson(jSONObject.optJSONObject("from_forum"));
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                if (this.author != null && context != null) {
                    this.fMG = String.valueOf(this.author.getUserName()) + context.getResources().getString(w.l.somebodys_portrait);
                    this.fMH = String.format(TbadkCoreApplication.m9getInst().getString(w.l.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.fMD = new h(jSONObject.optJSONObject("tpoint_post"));
                JSONArray optJSONArray = jSONObject.optJSONArray("content");
                this.fMs = jSONObject.optInt("sub_post_number");
                if (context == null) {
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            k kVar = new k();
                            kVar.parserJson(optJSONArray.optJSONObject(i));
                            this.dvP.add(kVar);
                        }
                    }
                } else {
                    this.dyV = TbRichTextView.a(context, optJSONArray, true);
                    if (this.dyV != null) {
                        this.dyV.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    }
                }
                if (this.fMs > 0) {
                    JSONArray optJSONArray2 = jSONObject.optJSONObject("sub_post_list").optJSONArray("sub_post_list");
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(optJSONArray2.getJSONObject(i2), context);
                        this.fMt.add(postData);
                    }
                }
                this.bimg_url = jSONObject.optString("bimg_url");
                JSONObject optJSONObject = jSONObject.optJSONObject("act_post");
                if (optJSONObject != null) {
                    this.fMx.parserJson(optJSONObject);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("tail_info");
                if (optJSONObject2 != null) {
                    this.fMz = new com.baidu.tbadk.data.b();
                    this.fMz.parserJson(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("lbs_info");
                if (optJSONObject3 != null) {
                    this.fMA = new com.baidu.tbadk.data.g();
                    this.fMA.parserJson(optJSONObject3);
                }
                this.fMw.parserJson(jSONObject.optJSONObject("present"));
                this.XS.setUserMap(this.userMap);
                this.XS.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                JSONArray optJSONArray3 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray3 != null) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.parserJson(optJSONArray3.getJSONObject(i3));
                        this.YB.add(bVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("agree");
                if (optJSONObject4 != null) {
                    this.fML = optJSONObject4.optLong("agree_num", 0L);
                    this.fMM = optJSONObject4.optLong("has_agree", 0L) == 1;
                    this.fMK = true;
                } else {
                    this.fMK = false;
                }
                this.fMR = jSONObject.optInt("is_post_visible") == 1;
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
                this.date = aw.q(this.time);
                this.erc = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                this.fMN = post.need_log.intValue() == 1;
                this.fME = new bf();
                this.fME.parserProtobuf(post.from_forum);
                if (this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) {
                    this.author.parserProtobuf(post.author);
                }
                if (this.author != null && context != null) {
                    this.fMG = String.valueOf(this.author.getUserName()) + context.getResources().getString(w.l.somebodys_portrait);
                    this.fMH = String.format(TbadkCoreApplication.m9getInst().getString(w.l.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.fMy = post.is_ntitle.intValue() == 1;
                this.fMs = post.sub_post_number.intValue();
                this.fMD = new h(post.tpoint_post);
                this.dyV = TbRichTextView.b(context, post.content, true);
                if (this.dyV != null) {
                    this.dyV.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.dyV.fs(this.floor_num);
                    if (this.author != null) {
                        this.dyV.setAuthorId(this.author.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.fMB = subPostList.is_giftpost.intValue() == 1;
                            postData.setUserMap(this.userMap);
                            postData.a(subPostList, context);
                            this.fMt.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.fMx.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.fMz = new com.baidu.tbadk.data.b();
                    this.fMz.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.fMA = new com.baidu.tbadk.data.g();
                    this.fMA.a(post.lbs_info);
                }
                this.Yp = post.storecount.intValue();
                this.fMw.a(post.present);
                this.XS.setUserMap(this.userMap);
                this.XS.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.eIP = new SmallTailInfo();
                    this.eIP.id = post.signature.signature_id.intValue();
                    this.eIP.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.eIP.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.eIP.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.eIP.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.a(post.ext_tails.get(i2));
                        this.YB.add(bVar);
                    }
                }
                this.YD = post.skin_info;
                this.YG = post.lego_card;
                this.fMJ = post.tpoint_post;
                if (post.agree != null) {
                    this.fMK = true;
                    this.fMM = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.fML = post.agree.agree_num.longValue();
                    } else {
                        this.fML = 0L;
                    }
                } else {
                    this.fMK = false;
                }
                this.fMR = post.is_post_visible.intValue() == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int eHc;

        public CustomForegroundColorSpan(int i) {
            super(as.getColor(i));
            this.eHc = i;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(as.getColor(this.eHc));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> fMX;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.fMX = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(as.getColor(w.e.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.fMX != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.fMX.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String bO(Context context) {
        ArrayList<TbRichTextData> HU;
        if (this.dyV == null || (HU = this.dyV.HU()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = HU.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.Ib().toString());
            } else if (next.getType() == 17) {
                String str = next.If().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(w.l.editor_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(w.l.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(w.l.msglist_video) + "]");
            } else if (next.getType() == 1536) {
                stringBuffer.append("[" + context.getString(w.l.graffiti) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public PreLoadImageInfo bmz() {
        ArrayList<TbRichTextData> HU;
        if (this.dyV != null && (HU = this.dyV.HU()) != null) {
            Iterator<TbRichTextData> it = HU.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.Ia().getWidth();
                    preLoadImageInfo.height = next.Ia().getHeight();
                    preLoadImageInfo.imgUrl = next.Ia().Ip();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 1536) {
                    if (next.Ik() == null || TextUtils.isEmpty(next.Ik().url)) {
                        return null;
                    }
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.imgUrl = next.Ik().url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String bmA() {
        j blX;
        PreLoadImageInfo bmz = bmz();
        if (bmz != null && !StringUtils.isNull(bmz.imgUrl)) {
            return bmz.imgUrl;
        }
        if (this.fMD != null && (blX = this.fMD.blX()) != null && !StringUtils.isNull(blX.bmd())) {
            return blX.bmd();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.aj
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> HU;
        if (this.dyV == null || (HU = this.dyV.HU()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = HU.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.Ia().getWidth();
                preLoadImageInfo.height = next.Ia().getHeight();
                preLoadImageInfo.imgUrl = next.Ia().Ip();
                preLoadImageInfo.procType = 17;
                arrayList.add(preLoadImageInfo);
            } else if (next.If() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.If().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.If().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.If();
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
        if (this.author == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.author.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.fMr == 52) {
            return fMp;
        }
        if (this.fMr == 2) {
            return fMh;
        }
        if (this.fMr == 1) {
            return YE;
        }
        if (this.fMr == 36) {
            return fMi;
        }
        if (this.fMr == 40 || this.fMr == 50) {
            return Xr;
        }
        if (this.fMr == 41) {
            return fMm;
        }
        if (bmu() == 1) {
            return fMf;
        }
        return fMg;
    }

    public void setPostType(int i) {
        this.fMr = i;
    }

    public at bmB() {
        return this.fMw;
    }

    public void a(at atVar) {
        this.fMw = atVar;
    }

    public h bmC() {
        return this.fMD;
    }

    public com.baidu.tbadk.widget.richText.e Ie() {
        if (this.fMF != null) {
            return this.fMF;
        }
        if (this.dyV != null && z.s(this.dyV.HU()) > 0) {
            Iterator<TbRichTextData> it = this.dyV.HU().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.fMF = next.Ie();
                    return this.fMF;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo Ic() {
        if (this.anc != null) {
            return this.anc;
        }
        if (this.dyV != null && z.s(this.dyV.HU()) > 0) {
            Iterator<TbRichTextData> it = this.dyV.HU().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.anc = next.Ic();
                    return this.anc;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.tbadk.data.b> bmD() {
        return this.YB;
    }

    public String bmE() {
        return this.fMG;
    }

    public String bmF() {
        return this.fMH;
    }

    public String sm() {
        return this.YG;
    }

    public void sp() {
        if (this.Yf == 0) {
            this.Yf = 1;
        }
    }

    public long bmG() {
        return this.fML;
    }

    public void cG(long j) {
        this.fML = j;
    }

    public boolean bmH() {
        return this.fMM;
    }

    public void lS(boolean z) {
        this.fMM = z;
    }

    public bf bmI() {
        return this.fME;
    }
}
