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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.ar;
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
public class PostData implements v, ah {
    private SkinInfo YC;
    private String YF;
    private TbRichTextVoiceInfo aNc;
    @Deprecated
    private String authorId;
    private String bimg_url;
    private String eif;
    private SmallTailInfo ezt;
    private be fCA;
    private com.baidu.tbadk.widget.richText.e fCB;
    private String fCC;
    private String fCD;
    private TPointPost fCF;
    public int fCJ;
    private ArrayList<PostData> fCp;
    private com.baidu.tbadk.data.b fCv;
    private com.baidu.tbadk.data.g fCw;
    private h fCz;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId fCb = BdUniqueId.gen();
    public static final BdUniqueId fCc = BdUniqueId.gen();
    public static final BdUniqueId fCd = BdUniqueId.gen();
    public static final BdUniqueId YD = BdUniqueId.gen();
    public static final BdUniqueId fCe = BdUniqueId.gen();
    public static final BdUniqueId Xr = BdUniqueId.gen();
    public static final BdUniqueId fCf = BdUniqueId.gen();
    public static final BdUniqueId fCg = BdUniqueId.gen();
    public static final BdUniqueId fCh = BdUniqueId.gen();
    public static final BdUniqueId fCi = BdUniqueId.gen();
    public static final BdUniqueId fCj = BdUniqueId.gen();
    public static final BdUniqueId ejb = BdUniqueId.gen();
    public static final BdUniqueId fCk = BdUniqueId.gen();
    public static final BdUniqueId fCl = BdUniqueId.gen();
    public static boolean fCm = false;
    private int fCn = 0;
    private boolean fCq = false;
    private ArrayList<PostData> fCr = null;
    private TbRichText dqh = null;
    private boolean fCu = false;
    private boolean fCx = false;
    private boolean fCy = false;
    public int Ye = 0;
    public boolean fCE = false;
    private boolean fCG = false;
    private long fCH = 0;
    private boolean fCI = false;
    public boolean fCK = false;
    public boolean fCL = true;
    public boolean cdg = false;
    public boolean fCM = false;
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData author = new MetaData();
    private ArrayList<k> dnT = new ArrayList<>();
    private ArrayList<k> doK = new ArrayList<>();
    private int fCo = 0;
    private int Yo = 0;
    private PraiseData XS = new PraiseData();
    private as fCs = new as();
    private c fCt = new c();
    private ArrayList<com.baidu.tbadk.data.b> YA = new ArrayList<>();

    public PostData() {
        this.fCp = null;
        this.fCJ = 0;
        this.fCp = new ArrayList<>();
        this.fCJ = 0;
    }

    public ArrayList<PostData> bia() {
        return this.fCr;
    }

    public void w(PostData postData) {
        if (postData != null) {
            if (this.fCr == null) {
                this.fCr = new ArrayList<>();
                if (x.q(this.fCp) > 2) {
                    this.fCr.addAll(x.a(this.fCp, 0, 2));
                } else {
                    this.fCr.addAll(this.fCp);
                }
            }
            this.fCr.add(postData);
        }
    }

    public void x(PostData postData) {
        if (postData != null && this.fCp != null) {
            this.fCp.add(postData);
            bie();
        }
    }

    public void qm(String str) {
        if (this.fCr != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.fCr.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.fCr.remove(next);
                    return;
                }
            }
        }
    }

    public void lr(boolean z) {
        this.fCq = z;
    }

    public boolean bib() {
        return this.fCq;
    }

    public c bic() {
        return this.fCt;
    }

    public ArrayList<PostData> bid() {
        return this.fCp;
    }

    public void bie() {
        this.fCo++;
    }

    public void bif() {
        this.fCo--;
    }

    public void sl(int i) {
        this.fCo = i;
    }

    public boolean isGiftPost() {
        return this.fCx;
    }

    public void setIsGiftPost(boolean z) {
        this.fCx = z;
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

    public String aIn() {
        return this.eif;
    }

    public int big() {
        return this.floor_num;
    }

    public void sm(int i) {
        this.floor_num = i;
    }

    public boolean bih() {
        return this.fCy;
    }

    public void ls(boolean z) {
        this.fCy = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = au.q(j);
    }

    public String bii() {
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

    public TbRichText avd() {
        return this.dqh;
    }

    public void f(TbRichText tbRichText) {
        this.dqh = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo aOB() {
        return this.ezt;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.ezt = smallTailInfo;
    }

    public com.baidu.tbadk.data.g bij() {
        return this.fCw;
    }

    public SkinInfo rP() {
        return this.YC;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.dqh != null && this.dqh.Hx() != null) {
            BdUniqueId uniqueId = tbPageContext.getUniqueId();
            ArrayList<IconData> tShowInfoNew = getAuthor().getTShowInfoNew();
            if (tShowInfoNew != null) {
                tShowInfoNew.size();
            }
            String str3 = z ? " 楼主" : "";
            TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds36);
            ArrayList arrayList = new ArrayList();
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
                Bitmap cM = aq.cM(w.g.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cM);
                if (cM != null) {
                    bitmapDrawable.setBounds(0, 0, cM.getWidth(), cM.getHeight());
                }
                ar arVar = new ar(bitmapDrawable);
                arVar.setOffset(com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds2));
                int size = arrayList.size() + this.author.getSealPrefix().length() + 1;
                spannableString.setSpan(arVar, size, size + 1, 17);
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
            ArrayList<TbRichTextData> Hx = this.dqh.Hx();
            if (Hx != null && Hx.size() > 0) {
                TbRichTextData tbRichTextData2 = Hx.get(0);
                if (tbRichTextData2.HE() != null) {
                    tbRichTextData2.fr(sb.length());
                    tbRichTextData2.HE().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= Hx.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (Hx.get(i4) == null || Hx.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        TbRichTextVoiceInfo HF = Hx.get(i4).HF();
                        Hx.remove(i4);
                        tbRichTextVoiceInfo = HF;
                        break;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.a(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.fr(sb.length());
                tbRichTextData.append(spannableString);
                Hx.add(0, tbRichTextData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable g(com.baidu.adp.widget.a.a aVar) {
        Bitmap kR;
        if (aVar == null || (kR = aVar.kR()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(kR);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(w.f.ds36), TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(w.f.ds36));
        return bitmapDrawable;
    }

    public int bik() {
        return this.fCo;
    }

    public void bS(Context context) {
        int type;
        int i;
        int i2;
        if (this.dnT != null) {
            int i3 = -1;
            int size = this.doK.size();
            if (size > 0) {
                try {
                    i3 = this.doK.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.dnT.size()) {
                k kVar = this.dnT.get(i4);
                if (k.bm(i5, kVar.getType())) {
                    this.doK.get(size - 1).a(kVar.bR(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.doK.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.a(kVar.bR(context));
                        this.doK.add(kVar2);
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

    public void bT(Context context) {
        try {
            if (this.dqh != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.dqh.toString());
                clipboardManager.getText();
                return;
            }
            if (this.doK == null || this.doK.size() == 0) {
                bS(context);
            }
            ArrayList<k> arrayList = this.doK;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.bhS() != null) {
                            sb.append((CharSequence) next.bhS());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(w.l.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(w.l.voice_str));
                    } else if (next.getType() == 2) {
                        String ff = TbFaceManager.DG().ff(next.getText());
                        if (ff != null) {
                            sb.append("[");
                            sb.append(ff);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !au.isEmpty(next.bhR())) {
                        sb.append("[").append(next.bhR()).append("]");
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
                this.date = au.q(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.fCx = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.dqh = TbRichTextView.b(context, subPostList.content, z);
                if (this.dqh != null) {
                    this.dqh.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
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
                this.date = au.q(this.time);
                this.eif = jSONObject.optString("time_ex");
                MetaData metaData2 = new MetaData();
                metaData2.parserJson(jSONObject.optJSONObject("author"));
                this.authorId = jSONObject.optString("author_id");
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                this.fCA = new be();
                this.fCA.parserJson(jSONObject.optJSONObject("from_forum"));
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                if (this.author != null && context != null) {
                    this.fCC = String.valueOf(this.author.getUserName()) + context.getResources().getString(w.l.somebodys_portrait);
                    this.fCD = String.format(TbadkCoreApplication.m9getInst().getString(w.l.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.fCz = new h(jSONObject.optJSONObject("tpoint_post"));
                JSONArray optJSONArray = jSONObject.optJSONArray("content");
                this.fCo = jSONObject.optInt("sub_post_number");
                if (context == null) {
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            k kVar = new k();
                            kVar.parserJson(optJSONArray.optJSONObject(i));
                            this.dnT.add(kVar);
                        }
                    }
                } else {
                    this.dqh = TbRichTextView.a(context, optJSONArray, true);
                    if (this.dqh != null) {
                        this.dqh.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    }
                }
                if (this.fCo > 0) {
                    JSONArray optJSONArray2 = jSONObject.optJSONObject("sub_post_list").optJSONArray("sub_post_list");
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(optJSONArray2.getJSONObject(i2), context);
                        this.fCp.add(postData);
                    }
                }
                this.bimg_url = jSONObject.optString("bimg_url");
                JSONObject optJSONObject = jSONObject.optJSONObject("act_post");
                if (optJSONObject != null) {
                    this.fCt.parserJson(optJSONObject);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("tail_info");
                if (optJSONObject2 != null) {
                    this.fCv = new com.baidu.tbadk.data.b();
                    this.fCv.parserJson(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("lbs_info");
                if (optJSONObject3 != null) {
                    this.fCw = new com.baidu.tbadk.data.g();
                    this.fCw.parserJson(optJSONObject3);
                }
                this.fCs.parserJson(jSONObject.optJSONObject("present"));
                this.XS.setUserMap(this.userMap);
                this.XS.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                JSONArray optJSONArray3 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray3 != null) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.parserJson(optJSONArray3.getJSONObject(i3));
                        this.YA.add(bVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("agree");
                if (optJSONObject4 != null) {
                    this.fCH = optJSONObject4.optLong("agree_num", 0L);
                    this.fCI = optJSONObject4.optLong("has_agree", 0L) == 1;
                    this.fCG = true;
                } else {
                    this.fCG = false;
                }
                this.fCM = jSONObject.optInt("is_post_visible") == 1;
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
                this.date = au.q(this.time);
                this.eif = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                this.fCA = new be();
                this.fCA.parserProtobuf(post.from_forum);
                if (this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) {
                    this.author.parserProtobuf(post.author);
                }
                if (this.author != null && context != null) {
                    this.fCC = String.valueOf(this.author.getUserName()) + context.getResources().getString(w.l.somebodys_portrait);
                    this.fCD = String.format(TbadkCoreApplication.m9getInst().getString(w.l.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.fCu = post.is_ntitle.intValue() == 1;
                this.fCo = post.sub_post_number.intValue();
                this.fCz = new h(post.tpoint_post);
                this.dqh = TbRichTextView.b(context, post.content, true);
                if (this.dqh != null) {
                    this.dqh.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.dqh.fq(this.floor_num);
                    if (this.author != null) {
                        this.dqh.setAuthorId(this.author.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.fCx = subPostList.is_giftpost.intValue() == 1;
                            postData.setUserMap(this.userMap);
                            postData.a(subPostList, context);
                            this.fCp.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.fCt.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.fCv = new com.baidu.tbadk.data.b();
                    this.fCv.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.fCw = new com.baidu.tbadk.data.g();
                    this.fCw.a(post.lbs_info);
                }
                this.Yo = post.storecount.intValue();
                this.fCs.a(post.present);
                this.XS.setUserMap(this.userMap);
                this.XS.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.ezt = new SmallTailInfo();
                    this.ezt.id = post.signature.signature_id.intValue();
                    this.ezt.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.ezt.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.ezt.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.ezt.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.a(post.ext_tails.get(i2));
                        this.YA.add(bVar);
                    }
                }
                this.YC = post.skin_info;
                this.YF = post.lego_card;
                this.fCF = post.tpoint_post;
                if (post.agree != null) {
                    this.fCG = true;
                    this.fCI = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.fCH = post.agree.agree_num.longValue();
                    } else {
                        this.fCH = 0L;
                    }
                } else {
                    this.fCG = false;
                }
                this.fCM = post.is_post_visible.intValue() == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int exE;

        public CustomForegroundColorSpan(int i) {
            super(aq.getColor(i));
            this.exE = i;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aq.getColor(this.exE));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> fCS;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.fCS = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aq.getColor(w.e.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.fCS != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.fCS.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String bU(Context context) {
        ArrayList<TbRichTextData> Hx;
        if (this.dqh == null || (Hx = this.dqh.Hx()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = Hx.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.HE().toString());
            } else if (next.getType() == 17) {
                String str = next.HI().mGifInfo.mSharpText;
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

    public PreLoadImageInfo bil() {
        ArrayList<TbRichTextData> Hx;
        if (this.dqh != null && (Hx = this.dqh.Hx()) != null) {
            Iterator<TbRichTextData> it = Hx.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.HD().getWidth();
                    preLoadImageInfo.height = next.HD().getHeight();
                    preLoadImageInfo.imgUrl = next.HD().HR();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 1536) {
                    if (next.HM() == null || TextUtils.isEmpty(next.HM().url)) {
                        return null;
                    }
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.imgUrl = next.HM().url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String bim() {
        j bhJ;
        PreLoadImageInfo bil = bil();
        if (bil != null && !StringUtils.isNull(bil.imgUrl)) {
            return bil.imgUrl;
        }
        if (this.fCz != null && (bhJ = this.fCz.bhJ()) != null && !StringUtils.isNull(bhJ.bhP())) {
            return bhJ.bhP();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> Hx;
        if (this.dqh == null || (Hx = this.dqh.Hx()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = Hx.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.HD().getWidth();
                preLoadImageInfo.height = next.HD().getHeight();
                preLoadImageInfo.imgUrl = next.HD().HR();
                preLoadImageInfo.procType = 17;
                arrayList.add(preLoadImageInfo);
            } else if (next.HI() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.HI().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.HI().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.HI();
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
        if (this.fCn == 52) {
            return fCl;
        }
        if (this.fCn == 2) {
            return fCd;
        }
        if (this.fCn == 1) {
            return YD;
        }
        if (this.fCn == 36) {
            return fCe;
        }
        if (this.fCn == 40 || this.fCn == 50) {
            return Xr;
        }
        if (this.fCn == 41) {
            return fCi;
        }
        if (big() == 1) {
            return fCb;
        }
        return fCc;
    }

    public void setPostType(int i) {
        this.fCn = i;
    }

    public as bin() {
        return this.fCs;
    }

    public void a(as asVar) {
        this.fCs = asVar;
    }

    public h bio() {
        return this.fCz;
    }

    public com.baidu.tbadk.widget.richText.e HH() {
        if (this.fCB != null) {
            return this.fCB;
        }
        if (this.dqh != null && x.q(this.dqh.Hx()) > 0) {
            Iterator<TbRichTextData> it = this.dqh.Hx().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.fCB = next.HH();
                    return this.fCB;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo HF() {
        if (this.aNc != null) {
            return this.aNc;
        }
        if (this.dqh != null && x.q(this.dqh.Hx()) > 0) {
            Iterator<TbRichTextData> it = this.dqh.Hx().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.aNc = next.HF();
                    return this.aNc;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.tbadk.data.b> bip() {
        return this.YA;
    }

    public String biq() {
        return this.fCC;
    }

    public String bir() {
        return this.fCD;
    }

    public String sp() {
        return this.YF;
    }

    public void ss() {
        if (this.Ye == 0) {
            this.Ye = 1;
        }
    }

    public long bis() {
        return this.fCH;
    }

    public void cr(long j) {
        this.fCH = j;
    }

    public boolean bit() {
        return this.fCI;
    }

    public void lt(boolean z) {
        this.fCI = z;
    }

    public be biu() {
        return this.fCA;
    }
}
