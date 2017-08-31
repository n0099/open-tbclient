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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.c;
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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.m;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
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
public class PostData implements com.baidu.adp.widget.ListView.f, ae {
    private SkinInfo Zw;
    private String Zz;
    private TbRichTextVoiceInfo aoN;
    @Deprecated
    private String authorId;
    private String bimg_url;
    private String eDO;
    private SmallTailInfo eXj;
    private com.baidu.tbadk.data.a giC;
    private com.baidu.tbadk.data.h giD;
    private h giG;
    private be giH;
    private com.baidu.tbadk.widget.richText.e giJ;
    private String giK;
    private String giL;
    private TPointPost giN;
    public int giR;
    private ArrayList<PostData> giw;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId gii = BdUniqueId.gen();
    public static final BdUniqueId gij = BdUniqueId.gen();
    public static final BdUniqueId gik = BdUniqueId.gen();
    public static final BdUniqueId Zx = BdUniqueId.gen();
    public static final BdUniqueId gil = BdUniqueId.gen();
    public static final BdUniqueId Yk = BdUniqueId.gen();
    public static final BdUniqueId gim = BdUniqueId.gen();
    public static final BdUniqueId gin = BdUniqueId.gen();
    public static final BdUniqueId gio = BdUniqueId.gen();
    public static final BdUniqueId gip = BdUniqueId.gen();
    public static final BdUniqueId giq = BdUniqueId.gen();
    public static final BdUniqueId eEK = BdUniqueId.gen();
    public static final BdUniqueId gir = BdUniqueId.gen();
    public static final BdUniqueId gis = BdUniqueId.gen();
    public static boolean git = false;
    private int giu = 0;
    private boolean gix = false;
    private ArrayList<PostData> giy = null;
    private TbRichText dRp = null;
    private boolean giB = false;
    private boolean giE = false;
    private boolean giF = false;
    public boolean giI = false;
    public int YY = 0;
    public boolean giM = false;
    private boolean giO = false;
    private long ctl = 0;
    private boolean ctm = false;
    public boolean giP = false;
    public boolean giQ = false;
    public boolean giS = false;
    public boolean giT = true;
    public boolean czO = false;
    public boolean giU = false;
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData author = new MetaData();
    private ArrayList<k> dOl = new ArrayList<>();
    private ArrayList<k> dPa = new ArrayList<>();
    private int giv = 0;
    private int Zi = 0;
    private PraiseData YM = new PraiseData();
    private as giz = new as();
    private c giA = new c();
    private ArrayList<com.baidu.tbadk.data.a> Zu = new ArrayList<>();

    public PostData() {
        this.giw = null;
        this.giR = 0;
        this.giw = new ArrayList<>();
        this.giR = 0;
    }

    public ArrayList<PostData> bsi() {
        return this.giy;
    }

    public void z(PostData postData) {
        if (postData != null) {
            if (this.giy == null) {
                this.giy = new ArrayList<>();
                if (v.u(this.giw) > 2) {
                    this.giy.addAll(v.a(this.giw, 0, 2));
                } else {
                    this.giy.addAll(this.giw);
                }
            }
            this.giy.add(postData);
        }
    }

    public void A(PostData postData) {
        if (postData != null && this.giw != null) {
            this.giw.add(postData);
            bsm();
        }
    }

    public void sd(String str) {
        if (this.giy != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.giy.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.giy.remove(next);
                    return;
                }
            }
        }
    }

    public void mF(boolean z) {
        this.gix = z;
    }

    public boolean bsj() {
        return this.gix;
    }

    public c bsk() {
        return this.giA;
    }

    public ArrayList<PostData> bsl() {
        return this.giw;
    }

    public void bsm() {
        this.giv++;
    }

    public void bsn() {
        this.giv--;
    }

    public void tt(int i) {
        this.giv = i;
    }

    public boolean isGiftPost() {
        return this.giE;
    }

    public void setIsGiftPost(boolean z) {
        this.giE = z;
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

    public String aOJ() {
        return this.eDO;
    }

    public int bso() {
        return this.floor_num;
    }

    public void tu(int i) {
        this.floor_num = i;
    }

    public boolean bsp() {
        return this.giF;
    }

    public void mG(boolean z) {
        this.giF = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = am.r(j);
    }

    public String bsq() {
        return this.date;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public void a(PraiseData praiseData) {
        this.YM = praiseData;
    }

    public TbRichText aDg() {
        return this.dRp;
    }

    public void f(TbRichText tbRichText) {
        this.dRp = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo aVy() {
        return this.eXj;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.eXj = smallTailInfo;
    }

    public com.baidu.tbadk.data.h bsr() {
        return this.giD;
    }

    public SkinInfo rW() {
        return this.Zw;
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.dRp != null && this.dRp.Iv() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            String str3 = z ? " 楼主" : "";
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = getAuthor().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fK().a(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.f.c.fK().a(next.getIcon(), 21, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.f.b
                                    public void onLoaded(com.baidu.adp.widget.a.a aVar2, String str4, int i) {
                                        super.onLoaded((C01251) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.kP()) {
                                            cVar2.setDrawable(PostData.this.g(aVar2));
                                            PostData.this.dRp.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.g(aVar);
                        }
                    }, 0, 1);
                    cVar.c(0, 0, TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.f.ds32), TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.f.ds32));
                    arrayList.add(cVar);
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
                spannableString = new SpannableString(sb2 + str3 + "：");
                str2 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.author.getName_show() + str3 + "：");
                str = this.author.getUserName();
                str2 = this.author.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.author.getSealPrefix())) {
                Bitmap cT = aj.cT(d.g.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cT);
                if (cT != null) {
                    bitmapDrawable.setBounds(0, 0, cT.getWidth(), cT.getHeight());
                }
                m mVar = new m(bitmapDrawable);
                mVar.setOffset(com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), d.f.ds2));
                int size = arrayList.size() + this.author.getSealPrefix().length() + 1;
                spannableString.setSpan(mVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str, str2), 0, spannableString.length(), 18);
            if (z) {
                CustomForegroundColorSpan customForegroundColorSpan = new CustomForegroundColorSpan(d.e.cp_link_tip_a);
                if (this.author != null) {
                    spannableString.setSpan(customForegroundColorSpan, sb2.length() + this.author.getName_show().length() + 1, str3.length() + sb2.length() + this.author.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(customForegroundColorSpan, sb2.length(), str3.length() + sb2.length(), 17);
                }
            }
            ArrayList<TbRichTextData> Iv = this.dRp.Iv();
            if (Iv != null && Iv.size() > 0) {
                TbRichTextData tbRichTextData2 = Iv.get(0);
                if (tbRichTextData2.IC() != null) {
                    tbRichTextData2.fz(sb.length());
                    tbRichTextData2.IC().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= Iv.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (Iv.get(i4) == null || Iv.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        TbRichTextVoiceInfo ID = Iv.get(i4).ID();
                        Iv.remove(i4);
                        tbRichTextVoiceInfo = ID;
                        break;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.a(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.fz(sb.length());
                tbRichTextData.append(spannableString);
                Iv.add(0, tbRichTextData);
            }
        }
    }

    public void c(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        TbRichTextData tbRichTextData;
        TbRichTextVoiceInfo tbRichTextVoiceInfo = null;
        if (tbPageContext != null && this.dRp != null && this.dRp.Iv() != null) {
            String str3 = z ? " 楼主" : "";
            String sb = new StringBuilder().toString();
            String name_show = this.author.getName_show();
            if (com.baidu.adp.lib.util.j.aP(this.author.getName_show()) > 14) {
                name_show = am.e(this.author.getName_show(), 14, "...");
            }
            if (this.author != null) {
                spannableString = new SpannableString(sb + name_show + str3 + "：");
                str = this.author.getUserName();
                str2 = this.author.getUserId();
            } else {
                str = null;
                spannableString = new SpannableString(sb + str3 + "：");
                str2 = null;
            }
            if (!StringUtils.isNull(this.author.getSealPrefix())) {
                Bitmap cT = aj.cT(d.g.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cT);
                if (cT != null) {
                    bitmapDrawable.setBounds(0, 0, cT.getWidth(), cT.getHeight());
                }
                m mVar = new m(bitmapDrawable);
                mVar.setOffset(com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), d.f.ds2));
                int length = this.author.getSealPrefix().length() + 1;
                spannableString.setSpan(mVar, length, length + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str, str2), 0, spannableString.length(), 18);
            if (z) {
                AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), d.f.ds28));
                CustomForegroundColorSpan customForegroundColorSpan = new CustomForegroundColorSpan(d.e.cp_link_tip_a);
                if (this.author != null) {
                    spannableString.setSpan(absoluteSizeSpan, sb.length() + this.author.getName_show().length() + 1, sb.length() + this.author.getName_show().length() + str3.length(), 17);
                    spannableString.setSpan(customForegroundColorSpan, sb.length() + this.author.getName_show().length() + 1, str3.length() + sb.length() + this.author.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(absoluteSizeSpan, sb.length(), sb.length() + str3.length(), 17);
                    spannableString.setSpan(customForegroundColorSpan, sb.length(), str3.length() + sb.length(), 17);
                }
            }
            ArrayList<TbRichTextData> Iv = this.dRp.Iv();
            if (Iv != null && Iv.size() > 0) {
                TbRichTextData tbRichTextData2 = Iv.get(0);
                if (tbRichTextData2.IC() != null) {
                    tbRichTextData2.IC().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i = 0;
                while (true) {
                    if (i < Iv.size()) {
                        if (Iv.get(i) == null || Iv.get(i).getType() != 512) {
                            i++;
                        } else {
                            tbRichTextVoiceInfo = Iv.get(i).ID();
                            Iv.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.a(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.append(spannableString);
                Iv.add(0, tbRichTextData);
            }
        }
    }

    protected Drawable g(com.baidu.adp.widget.a.a aVar) {
        Bitmap kO;
        if (aVar == null || (kO = aVar.kO()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(kO);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.f.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.f.ds36));
        return bitmapDrawable;
    }

    public int bss() {
        return this.giv;
    }

    public void bX(Context context) {
        int type;
        int i;
        int i2;
        if (this.dOl != null) {
            int i3 = -1;
            int size = this.dPa.size();
            if (size > 0) {
                try {
                    i3 = this.dPa.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.dOl.size()) {
                k kVar = this.dOl.get(i4);
                if (k.bI(i5, kVar.getType())) {
                    this.dPa.get(size - 1).b(kVar.bW(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.dPa.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.bW(context));
                        this.dPa.add(kVar2);
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

    public void bY(Context context) {
        try {
            if (this.dRp != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.dRp.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.dPa == null || this.dPa.size() == 0) {
                bX(context);
            }
            ArrayList<k> arrayList = this.dPa;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.bsa() != null) {
                            sb.append((CharSequence) next.bsa());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(d.l.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(d.l.voice_str));
                    } else if (next.getType() == 2) {
                        String fI = TbFaceManager.Eu().fI(next.getText());
                        if (fI != null) {
                            sb.append("[");
                            sb.append(fI);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !am.isEmpty(next.brZ())) {
                        sb.append("[").append(next.brZ()).append("]");
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
                this.date = am.r(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.giE = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.dRp = TbRichTextView.a(context, subPostList.content, z);
                if (this.dRp != null) {
                    this.dRp.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
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
                this.date = am.r(this.time);
                this.eDO = jSONObject.optString("time_ex");
                MetaData metaData2 = new MetaData();
                metaData2.parserJson(jSONObject.optJSONObject("author"));
                this.authorId = jSONObject.optString("author_id");
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                this.giH = new be();
                this.giH.parserJson(jSONObject.optJSONObject("from_forum"));
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                if (this.author != null && context != null) {
                    this.giK = this.author.getUserName() + context.getResources().getString(d.l.somebodys_portrait);
                    this.giL = String.format(TbadkCoreApplication.getInst().getString(d.l.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.giG = new h(jSONObject.optJSONObject("tpoint_post"));
                JSONArray optJSONArray = jSONObject.optJSONArray("content");
                this.giv = jSONObject.optInt("sub_post_number");
                if (context == null) {
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            k kVar = new k();
                            kVar.parserJson(optJSONArray.optJSONObject(i));
                            this.dOl.add(kVar);
                        }
                    }
                } else {
                    this.dRp = TbRichTextView.a(context, optJSONArray, true);
                    if (this.dRp != null) {
                        this.dRp.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    }
                }
                if (this.giv > 0) {
                    JSONArray optJSONArray2 = jSONObject.optJSONObject("sub_post_list").optJSONArray("sub_post_list");
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(optJSONArray2.getJSONObject(i2), context);
                        this.giw.add(postData);
                    }
                }
                this.bimg_url = jSONObject.optString("bimg_url");
                JSONObject optJSONObject = jSONObject.optJSONObject("act_post");
                if (optJSONObject != null) {
                    this.giA.parserJson(optJSONObject);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("tail_info");
                if (optJSONObject2 != null) {
                    this.giC = new com.baidu.tbadk.data.a();
                    this.giC.parserJson(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("lbs_info");
                if (optJSONObject3 != null) {
                    this.giD = new com.baidu.tbadk.data.h();
                    this.giD.parserJson(optJSONObject3);
                }
                this.giz.parserJson(jSONObject.optJSONObject("present"));
                this.YM.setUserMap(this.userMap);
                this.YM.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                JSONArray optJSONArray3 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray3 != null) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        com.baidu.tbadk.data.a aVar = new com.baidu.tbadk.data.a();
                        aVar.parserJson(optJSONArray3.getJSONObject(i3));
                        this.Zu.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("agree");
                if (optJSONObject4 != null) {
                    this.ctl = optJSONObject4.optLong("agree_num", 0L);
                    this.ctm = optJSONObject4.optLong("has_agree", 0L) == 1;
                    this.giO = true;
                } else {
                    this.giO = false;
                }
                this.giU = jSONObject.optInt("is_post_visible") == 1;
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
                this.date = am.r(this.time);
                this.eDO = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                this.giP = post.need_log.intValue() == 1;
                this.giQ = post.img_num_abtest.intValue() == 1;
                this.giH = new be();
                this.giH.parserProtobuf(post.from_forum);
                if (this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) {
                    this.author.parserProtobuf(post.author);
                }
                if (this.author != null && context != null) {
                    this.giK = this.author.getUserName() + context.getResources().getString(d.l.somebodys_portrait);
                    this.giL = String.format(TbadkCoreApplication.getInst().getString(d.l.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.giB = post.is_ntitle.intValue() == 1;
                this.giv = post.sub_post_number.intValue();
                this.giG = new h(post.tpoint_post);
                this.dRp = TbRichTextView.a(context, post.content, true);
                if (this.dRp != null) {
                    this.dRp.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.dRp.fy(this.floor_num);
                    if (this.author != null) {
                        this.dRp.setAuthorId(this.author.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.giE = subPostList.is_giftpost.intValue() == 1;
                            postData.setUserMap(this.userMap);
                            postData.a(subPostList, context);
                            this.giw.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.giA.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.giC = new com.baidu.tbadk.data.a();
                    this.giC.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.giD = new com.baidu.tbadk.data.h();
                    this.giD.a(post.lbs_info);
                }
                this.Zi = post.storecount.intValue();
                this.giz.a(post.present);
                this.YM.setUserMap(this.userMap);
                this.YM.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.eXj = new SmallTailInfo();
                    this.eXj.id = post.signature.signature_id.intValue();
                    this.eXj.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.eXj.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.eXj.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.eXj.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.a aVar = new com.baidu.tbadk.data.a();
                        aVar.a(post.ext_tails.get(i2));
                        this.Zu.add(aVar);
                    }
                }
                this.Zw = post.skin_info;
                this.Zz = post.lego_card;
                this.giN = post.tpoint_post;
                if (post.agree != null) {
                    this.giO = true;
                    this.ctm = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.ctl = post.agree.agree_num.longValue();
                    } else {
                        this.ctl = 0L;
                    }
                } else {
                    this.giO = false;
                }
                this.giU = post.is_post_visible.intValue() == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int eVq;

        public CustomForegroundColorSpan(int i) {
            super(aj.getColor(i));
            this.eVq = i;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aj.getColor(this.eVq));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> gja;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.gja = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aj.getColor(d.e.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.gja != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.gja.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String bZ(Context context) {
        ArrayList<TbRichTextData> Iv;
        if (this.dRp == null || (Iv = this.dRp.Iv()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = Iv.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.IC().toString());
            } else if (next.getType() == 17) {
                String str = next.IG().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(d.l.editor_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(d.l.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(d.l.msglist_video) + "]");
            } else if (next.getType() == 1536) {
                stringBuffer.append("[" + context.getString(d.l.graffiti) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public PreLoadImageInfo bst() {
        ArrayList<TbRichTextData> Iv;
        if (this.dRp != null && (Iv = this.dRp.Iv()) != null) {
            Iterator<TbRichTextData> it = Iv.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.IB().getWidth();
                    preLoadImageInfo.height = next.IB().getHeight();
                    preLoadImageInfo.imgUrl = next.IB().IQ();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 1536) {
                    if (next.IL() == null || TextUtils.isEmpty(next.IL().url)) {
                        return null;
                    }
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.imgUrl = next.IL().url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String bsu() {
        j brR;
        PreLoadImageInfo bst = bst();
        if (bst != null && !StringUtils.isNull(bst.imgUrl)) {
            return bst.imgUrl;
        }
        if (this.giG != null && (brR = this.giG.brR()) != null && !StringUtils.isNull(brR.brX())) {
            return brR.brX();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> Iv;
        if (this.dRp == null || (Iv = this.dRp.Iv()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = Iv.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.IB().getWidth();
                preLoadImageInfo.height = next.IB().getHeight();
                preLoadImageInfo.imgUrl = next.IB().IQ();
                preLoadImageInfo.procType = 17;
                arrayList.add(preLoadImageInfo);
            } else if (next.IG() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.IG().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.IG().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.IG();
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

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.giu == 52) {
            return gis;
        }
        if (this.giu == 2) {
            return gik;
        }
        if (this.giu == 1) {
            return Zx;
        }
        if (this.giu == 36) {
            return gil;
        }
        if (this.giu == 40 || this.giu == 50) {
            return Yk;
        }
        if (this.giu == 41) {
            return gip;
        }
        if (bso() == 1) {
            return gii;
        }
        return gij;
    }

    public void setPostType(int i) {
        this.giu = i;
    }

    public as bsv() {
        return this.giz;
    }

    public void a(as asVar) {
        this.giz = asVar;
    }

    public h bsw() {
        return this.giG;
    }

    public com.baidu.tbadk.widget.richText.e IF() {
        if (this.giJ != null) {
            return this.giJ;
        }
        if (this.dRp != null && v.u(this.dRp.Iv()) > 0) {
            Iterator<TbRichTextData> it = this.dRp.Iv().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.giJ = next.IF();
                    return this.giJ;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo ID() {
        if (this.aoN != null) {
            return this.aoN;
        }
        if (this.dRp != null && v.u(this.dRp.Iv()) > 0) {
            Iterator<TbRichTextData> it = this.dRp.Iv().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.aoN = next.ID();
                    return this.aoN;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.tbadk.data.a> bsx() {
        return this.Zu;
    }

    public String bsy() {
        return this.giK;
    }

    public String bsz() {
        return this.giL;
    }

    public String sw() {
        return this.Zz;
    }

    public void sz() {
        if (this.YY == 0) {
            this.YY = 1;
        }
    }

    public long bsA() {
        return this.ctl;
    }

    public void cO(long j) {
        this.ctl = j;
    }

    public boolean bsB() {
        return this.ctm;
    }

    public void mH(boolean z) {
        this.ctm = z;
    }

    public be bsC() {
        return this.giH;
    }
}
