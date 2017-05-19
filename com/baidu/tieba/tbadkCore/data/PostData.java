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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.x;
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
    private SkinInfo YG;
    private String YJ;
    private TbRichTextVoiceInfo aNf;
    @Deprecated
    private String authorId;
    private String bimg_url;
    private String ecI;
    private SmallTailInfo esh;
    private com.baidu.tbadk.data.b fuE;
    private com.baidu.tbadk.data.f fuF;
    private h fuI;
    private bd fuJ;
    private com.baidu.tbadk.widget.richText.e fuK;
    private String fuL;
    private String fuM;
    private TPointPost fuO;
    public int fuS;
    private ArrayList<PostData> fuy;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId fuk = BdUniqueId.gen();
    public static final BdUniqueId ful = BdUniqueId.gen();
    public static final BdUniqueId fum = BdUniqueId.gen();
    public static final BdUniqueId YH = BdUniqueId.gen();
    public static final BdUniqueId fun = BdUniqueId.gen();
    public static final BdUniqueId Xv = BdUniqueId.gen();
    public static final BdUniqueId fuo = BdUniqueId.gen();
    public static final BdUniqueId fup = BdUniqueId.gen();
    public static final BdUniqueId fuq = BdUniqueId.gen();
    public static final BdUniqueId fur = BdUniqueId.gen();
    public static final BdUniqueId fus = BdUniqueId.gen();
    public static final BdUniqueId edD = BdUniqueId.gen();
    public static final BdUniqueId fut = BdUniqueId.gen();
    public static final BdUniqueId fuu = BdUniqueId.gen();
    public static boolean fuv = false;
    private int fuw = 0;
    private boolean fuz = false;
    private ArrayList<PostData> fuA = null;
    private TbRichText dkN = null;
    private boolean fuD = false;
    private boolean fuG = false;
    private boolean fuH = false;
    public int Yi = 0;
    public boolean fuN = false;
    private boolean fuP = false;
    private long fuQ = 0;
    private boolean fuR = false;
    public boolean fuT = false;
    public boolean fuU = true;
    public boolean bXh = false;
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData author = new MetaData();
    private ArrayList<k> diB = new ArrayList<>();
    private ArrayList<k> djq = new ArrayList<>();
    private int fux = 0;
    private int Ys = 0;
    private PraiseData XW = new PraiseData();
    private ar fuB = new ar();
    private c fuC = new c();
    private ArrayList<com.baidu.tbadk.data.b> YE = new ArrayList<>();

    public PostData() {
        this.fuy = null;
        this.fuS = 0;
        this.fuy = new ArrayList<>();
        this.fuS = 0;
    }

    public ArrayList<PostData> bgF() {
        return this.fuA;
    }

    public void v(PostData postData) {
        if (postData != null) {
            if (this.fuA == null) {
                this.fuA = new ArrayList<>();
                if (x.q(this.fuy) > 2) {
                    this.fuA.addAll(x.a(this.fuy, 0, 2));
                } else {
                    this.fuA.addAll(this.fuy);
                }
            }
            this.fuA.add(postData);
        }
    }

    public void w(PostData postData) {
        if (postData != null && this.fuy != null) {
            this.fuy.add(postData);
            bgK();
        }
    }

    public void pY(String str) {
        if (this.fuA != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.fuA.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.fuA.remove(next);
                    return;
                }
            }
        }
    }

    public void kW(boolean z) {
        this.fuz = z;
    }

    public boolean bgG() {
        return this.fuz;
    }

    public TPointPost bgH() {
        return this.fuO;
    }

    public c bgI() {
        return this.fuC;
    }

    public ArrayList<PostData> bgJ() {
        return this.fuy;
    }

    public void bgK() {
        this.fux++;
    }

    public void bgL() {
        this.fux--;
    }

    public void rP(int i) {
        this.fux = i;
    }

    public boolean isGiftPost() {
        return this.fuG;
    }

    public void setIsGiftPost(boolean z) {
        this.fuG = z;
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

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String aHs() {
        return this.ecI;
    }

    public int bgM() {
        return this.floor_num;
    }

    public void rQ(int i) {
        this.floor_num = i;
    }

    public boolean bgN() {
        return this.fuH;
    }

    public void kX(boolean z) {
        this.fuH = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = au.q(j);
    }

    public String bgO() {
        return this.date;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public void a(PraiseData praiseData) {
        this.XW = praiseData;
    }

    public TbRichText aui() {
        return this.dkN;
    }

    public void f(TbRichText tbRichText) {
        this.dkN = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo aNs() {
        return this.esh;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.esh = smallTailInfo;
    }

    public com.baidu.tbadk.data.f bgP() {
        return this.fuF;
    }

    public SkinInfo rT() {
        return this.YG;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.dkN != null && this.dkN.HC() != null) {
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
                Bitmap cL = aq.cL(w.g.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cL);
                if (cL != null) {
                    bitmapDrawable.setBounds(0, 0, cL.getWidth(), cL.getHeight());
                }
                com.baidu.tbadk.core.view.ar arVar = new com.baidu.tbadk.core.view.ar(bitmapDrawable);
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
            ArrayList<TbRichTextData> HC = this.dkN.HC();
            if (HC != null && HC.size() > 0) {
                TbRichTextData tbRichTextData2 = HC.get(0);
                if (tbRichTextData2.HJ() != null) {
                    tbRichTextData2.fq(sb.length());
                    tbRichTextData2.HJ().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= HC.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (HC.get(i4) == null || HC.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        TbRichTextVoiceInfo HK = HC.get(i4).HK();
                        HC.remove(i4);
                        tbRichTextVoiceInfo = HK;
                        break;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.a(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.fq(sb.length());
                tbRichTextData.append(spannableString);
                HC.add(0, tbRichTextData);
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

    public int bgQ() {
        return this.fux;
    }

    public void bR(Context context) {
        int type;
        int i;
        int i2;
        if (this.diB != null) {
            int i3 = -1;
            int size = this.djq.size();
            if (size > 0) {
                try {
                    i3 = this.djq.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.diB.size()) {
                k kVar = this.diB.get(i4);
                if (k.bm(i5, kVar.getType())) {
                    this.djq.get(size - 1).a(kVar.bQ(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.djq.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.a(kVar.bQ(context));
                        this.djq.add(kVar2);
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

    public void bS(Context context) {
        try {
            if (this.dkN != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.dkN.toString());
                clipboardManager.getText();
                return;
            }
            if (this.djq == null || this.djq.size() == 0) {
                bR(context);
            }
            ArrayList<k> arrayList = this.djq;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.bgx() != null) {
                            sb.append((CharSequence) next.bgx());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(w.l.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(w.l.voice_str));
                    } else if (next.getType() == 2) {
                        String fh = TbFaceManager.DM().fh(next.getText());
                        if (fh != null) {
                            sb.append("[");
                            sb.append(fh);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !au.isEmpty(next.bgw())) {
                        sb.append("[").append(next.bgw()).append("]");
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
                this.fuG = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.dkN = TbRichTextView.b(context, subPostList.content, z);
                if (this.dkN != null) {
                    this.dkN.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
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
                this.ecI = jSONObject.optString("time_ex");
                MetaData metaData2 = new MetaData();
                metaData2.parserJson(jSONObject.optJSONObject("author"));
                this.authorId = jSONObject.optString("author_id");
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                this.fuJ = new bd();
                this.fuJ.parserJson(jSONObject.optJSONObject("from_forum"));
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                if (this.author != null && context != null) {
                    this.fuL = String.valueOf(this.author.getUserName()) + context.getResources().getString(w.l.somebodys_portrait);
                    this.fuM = String.format(TbadkCoreApplication.m9getInst().getString(w.l.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.fuI = new h(jSONObject.optJSONObject("tpoint_post"));
                JSONArray optJSONArray = jSONObject.optJSONArray("content");
                this.fux = jSONObject.optInt("sub_post_number");
                if (context == null) {
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            k kVar = new k();
                            kVar.parserJson(optJSONArray.optJSONObject(i));
                            this.diB.add(kVar);
                        }
                    }
                } else {
                    this.dkN = TbRichTextView.a(context, optJSONArray, true);
                    if (this.dkN != null) {
                        this.dkN.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    }
                }
                if (this.fux > 0) {
                    JSONArray optJSONArray2 = jSONObject.optJSONObject("sub_post_list").optJSONArray("sub_post_list");
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(optJSONArray2.getJSONObject(i2), context);
                        this.fuy.add(postData);
                    }
                }
                this.bimg_url = jSONObject.optString("bimg_url");
                JSONObject optJSONObject = jSONObject.optJSONObject("act_post");
                if (optJSONObject != null) {
                    this.fuC.parserJson(optJSONObject);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("tail_info");
                if (optJSONObject2 != null) {
                    this.fuE = new com.baidu.tbadk.data.b();
                    this.fuE.parserJson(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("lbs_info");
                if (optJSONObject3 != null) {
                    this.fuF = new com.baidu.tbadk.data.f();
                    this.fuF.parserJson(optJSONObject3);
                }
                this.fuB.parserJson(jSONObject.optJSONObject("present"));
                this.XW.setUserMap(this.userMap);
                this.XW.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                JSONArray optJSONArray3 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray3 != null) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.parserJson(optJSONArray3.getJSONObject(i3));
                        this.YE.add(bVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("agree");
                if (optJSONObject4 != null) {
                    this.fuQ = optJSONObject4.optLong("agree_num", 0L);
                    this.fuR = optJSONObject4.optLong("has_agree", 0L) == 1;
                    this.fuP = true;
                    return;
                }
                this.fuP = false;
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
                this.ecI = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                this.fuJ = new bd();
                this.fuJ.parserProtobuf(post.from_forum);
                if (this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) {
                    this.author.parserProtobuf(post.author);
                }
                if (this.author != null && context != null) {
                    this.fuL = String.valueOf(this.author.getUserName()) + context.getResources().getString(w.l.somebodys_portrait);
                    this.fuM = String.format(TbadkCoreApplication.m9getInst().getString(w.l.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.fuD = post.is_ntitle.intValue() == 1;
                this.fux = post.sub_post_number.intValue();
                this.fuI = new h(post.tpoint_post);
                this.dkN = TbRichTextView.b(context, post.content, true);
                if (this.dkN != null) {
                    this.dkN.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.dkN.fp(this.floor_num);
                    if (this.author != null) {
                        this.dkN.setAuthorId(this.author.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.fuG = subPostList.is_giftpost.intValue() == 1;
                            postData.setUserMap(this.userMap);
                            postData.a(subPostList, context);
                            this.fuy.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.fuC.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.fuE = new com.baidu.tbadk.data.b();
                    this.fuE.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.fuF = new com.baidu.tbadk.data.f();
                    this.fuF.a(post.lbs_info);
                }
                this.Ys = post.storecount.intValue();
                this.fuB.a(post.present);
                this.XW.setUserMap(this.userMap);
                this.XW.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.esh = new SmallTailInfo();
                    this.esh.id = post.signature.signature_id.intValue();
                    this.esh.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.esh.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.esh.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.esh.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.a(post.ext_tails.get(i2));
                        this.YE.add(bVar);
                    }
                }
                this.YG = post.skin_info;
                this.YJ = post.lego_card;
                this.fuO = post.tpoint_post;
                if (post.agree != null) {
                    this.fuP = true;
                    this.fuR = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.fuQ = post.agree.agree_num.longValue();
                        return;
                    } else {
                        this.fuQ = 0L;
                        return;
                    }
                }
                this.fuP = false;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int equ;

        public CustomForegroundColorSpan(int i) {
            super(aq.getColor(i));
            this.equ = i;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aq.getColor(this.equ));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> fva;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.fva = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aq.getColor(w.e.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.fva != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.fva.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String bT(Context context) {
        ArrayList<TbRichTextData> HC;
        if (this.dkN == null || (HC = this.dkN.HC()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = HC.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.HJ().toString());
            } else if (next.getType() == 17) {
                String str = next.HN().mGifInfo.mSharpText;
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

    public PreLoadImageInfo bgR() {
        ArrayList<TbRichTextData> HC;
        if (this.dkN != null && (HC = this.dkN.HC()) != null) {
            Iterator<TbRichTextData> it = HC.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.HI().getWidth();
                    preLoadImageInfo.height = next.HI().getHeight();
                    preLoadImageInfo.imgUrl = next.HI().HW();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 1536) {
                    if (next.HR() == null || TextUtils.isEmpty(next.HR().url)) {
                        return null;
                    }
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.imgUrl = next.HR().url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String bgS() {
        j bgm;
        PreLoadImageInfo bgR = bgR();
        if (bgR != null && !StringUtils.isNull(bgR.imgUrl)) {
            return bgR.imgUrl;
        }
        if (this.fuI != null && (bgm = this.fuI.bgm()) != null && !StringUtils.isNull(bgm.bgt())) {
            return bgm.bgt();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> HC;
        if (this.dkN == null || (HC = this.dkN.HC()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = HC.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.HI().getWidth();
                preLoadImageInfo.height = next.HI().getHeight();
                preLoadImageInfo.imgUrl = next.HI().HW();
                preLoadImageInfo.procType = 17;
                arrayList.add(preLoadImageInfo);
            } else if (next.HN() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.HN().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.HN().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.HN();
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
        if (this.fuw == 52) {
            return fuu;
        }
        if (this.fuw == 2) {
            return fum;
        }
        if (this.fuw == 1) {
            return YH;
        }
        if (this.fuw == 36) {
            return fun;
        }
        if (this.fuw == 40 || this.fuw == 50) {
            return Xv;
        }
        if (this.fuw == 41) {
            return fur;
        }
        if (fuv) {
            if (this.fuI != null && this.fuI.ftS) {
                int bgq = this.fuI.bgq();
                if (bgq == 2) {
                    return fuo;
                }
                if (bgq == 1) {
                    return fup;
                }
                if (bgq == 3) {
                    return fuq;
                }
                if (bgM() == 1) {
                    return fuk;
                }
                return ful;
            } else if (this.fuw == 48) {
                return fut;
            }
        }
        if (bgM() == 1) {
            return fuk;
        }
        return ful;
    }

    public void setPostType(int i) {
        this.fuw = i;
    }

    public ar bgT() {
        return this.fuB;
    }

    public void a(ar arVar) {
        this.fuB = arVar;
    }

    public h bgU() {
        return this.fuI;
    }

    public com.baidu.tbadk.widget.richText.e HM() {
        if (this.fuK != null) {
            return this.fuK;
        }
        if (this.dkN != null && x.q(this.dkN.HC()) > 0) {
            Iterator<TbRichTextData> it = this.dkN.HC().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.fuK = next.HM();
                    return this.fuK;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo HK() {
        if (this.aNf != null) {
            return this.aNf;
        }
        if (this.dkN != null && x.q(this.dkN.HC()) > 0) {
            Iterator<TbRichTextData> it = this.dkN.HC().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.aNf = next.HK();
                    return this.aNf;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.tbadk.data.b> bgV() {
        return this.YE;
    }

    public String bgW() {
        return this.fuL;
    }

    public String bgX() {
        return this.fuM;
    }

    public String st() {
        return this.YJ;
    }

    public void sw() {
        if (this.Yi == 0) {
            this.Yi = 1;
        }
    }

    public long bgY() {
        return this.fuQ;
    }

    public void cm(long j) {
        this.fuQ = j;
    }

    public boolean bgZ() {
        return this.fuR;
    }

    public void kY(boolean z) {
        this.fuR = z;
    }

    public bd bha() {
        return this.fuJ;
    }
}
