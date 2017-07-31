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
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.u;
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
public class PostData implements com.baidu.adp.widget.ListView.f, ad {
    private SkinInfo aaq;
    private String aat;
    private TbRichTextVoiceInfo apg;
    @Deprecated
    private String authorId;
    private String bimg_url;
    private String eDy;
    private SmallTailInfo eWC;
    private ArrayList<PostData> gib;
    private com.baidu.tbadk.data.a gii;
    private com.baidu.tbadk.data.h gij;
    private h gim;
    private be gin;
    private com.baidu.tbadk.widget.richText.e gip;
    private String giq;
    private String gir;
    private TPointPost git;
    public int giy;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId ghN = BdUniqueId.gen();
    public static final BdUniqueId ghO = BdUniqueId.gen();
    public static final BdUniqueId ghP = BdUniqueId.gen();
    public static final BdUniqueId aar = BdUniqueId.gen();
    public static final BdUniqueId ghQ = BdUniqueId.gen();
    public static final BdUniqueId Zd = BdUniqueId.gen();
    public static final BdUniqueId ghR = BdUniqueId.gen();
    public static final BdUniqueId ghS = BdUniqueId.gen();
    public static final BdUniqueId ghT = BdUniqueId.gen();
    public static final BdUniqueId ghU = BdUniqueId.gen();
    public static final BdUniqueId ghV = BdUniqueId.gen();
    public static final BdUniqueId eEu = BdUniqueId.gen();
    public static final BdUniqueId ghW = BdUniqueId.gen();
    public static final BdUniqueId ghX = BdUniqueId.gen();
    public static boolean ghY = false;
    private int ghZ = 0;
    private boolean gic = false;
    private ArrayList<PostData> gie = null;
    private TbRichText dIO = null;
    private boolean gih = false;
    private boolean gik = false;
    private boolean gil = false;
    public boolean gio = false;
    public int ZS = 0;
    public boolean gis = false;
    private boolean giu = false;
    private long giv = 0;
    private boolean giw = false;
    public boolean gix = false;
    public boolean giz = false;
    public boolean giA = true;
    public boolean csE = false;
    public boolean giB = false;
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData author = new MetaData();
    private ArrayList<k> dFI = new ArrayList<>();
    private ArrayList<k> dGy = new ArrayList<>();
    private int gia = 0;
    private int aac = 0;
    private PraiseData ZF = new PraiseData();
    private as gif = new as();
    private c gig = new c();
    private ArrayList<com.baidu.tbadk.data.a> aao = new ArrayList<>();

    public PostData() {
        this.gib = null;
        this.giy = 0;
        this.gib = new ArrayList<>();
        this.giy = 0;
    }

    public ArrayList<PostData> bss() {
        return this.gie;
    }

    public void z(PostData postData) {
        if (postData != null) {
            if (this.gie == null) {
                this.gie = new ArrayList<>();
                if (u.u(this.gib) > 2) {
                    this.gie.addAll(u.a(this.gib, 0, 2));
                } else {
                    this.gie.addAll(this.gib);
                }
            }
            this.gie.add(postData);
        }
    }

    public void A(PostData postData) {
        if (postData != null && this.gib != null) {
            this.gib.add(postData);
            bsw();
        }
    }

    public void sb(String str) {
        if (this.gie != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.gie.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.gie.remove(next);
                    return;
                }
            }
        }
    }

    public void mw(boolean z) {
        this.gic = z;
    }

    public boolean bst() {
        return this.gic;
    }

    public c bsu() {
        return this.gig;
    }

    public ArrayList<PostData> bsv() {
        return this.gib;
    }

    public void bsw() {
        this.gia++;
    }

    public void bsx() {
        this.gia--;
    }

    public void th(int i) {
        this.gia = i;
    }

    public boolean isGiftPost() {
        return this.gik;
    }

    public void setIsGiftPost(boolean z) {
        this.gik = z;
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

    public String aOV() {
        return this.eDy;
    }

    public int bsy() {
        return this.floor_num;
    }

    public void ti(int i) {
        this.floor_num = i;
    }

    public boolean bsz() {
        return this.gil;
    }

    public void mx(boolean z) {
        this.gil = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = al.r(j);
    }

    public String bsA() {
        return this.date;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public void a(PraiseData praiseData) {
        this.ZF = praiseData;
    }

    public TbRichText aAP() {
        return this.dIO;
    }

    public void g(TbRichText tbRichText) {
        this.dIO = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo aVI() {
        return this.eWC;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.eWC = smallTailInfo;
    }

    public com.baidu.tbadk.data.h bsB() {
        return this.gij;
    }

    public SkinInfo sa() {
        return this.aaq;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.dIO != null && this.dIO.Io() != null) {
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
                            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fU().a(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.f.c.fU().a(next.getIcon(), 21, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.f.b
                                    public void onLoaded(com.baidu.adp.widget.a.a aVar2, String str4, int i) {
                                        super.onLoaded((C01211) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.kY()) {
                                            cVar2.setDrawable(PostData.this.g(aVar2));
                                            PostData.this.dIO.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.g(aVar);
                        }
                    }, 0, 1);
                    cVar.e(0, 0, TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.f.ds32), TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.f.ds32));
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
                Bitmap cS = ai.cS(d.g.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cS);
                if (cS != null) {
                    bitmapDrawable.setBounds(0, 0, cS.getWidth(), cS.getHeight());
                }
                m mVar = new m(bitmapDrawable);
                mVar.setOffset(com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), d.f.ds2));
                int size = arrayList.size() + this.author.getSealPrefix().length() + 1;
                spannableString.setSpan(mVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str, str2), 0, spannableString.length(), 18);
            if (z) {
                AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), d.f.ds28));
                CustomForegroundColorSpan customForegroundColorSpan = new CustomForegroundColorSpan(d.e.cp_link_tip_a);
                if (this.author != null) {
                    spannableString.setSpan(absoluteSizeSpan, sb2.length() + this.author.getName_show().length() + 1, sb2.length() + this.author.getName_show().length() + str3.length(), 17);
                    spannableString.setSpan(customForegroundColorSpan, sb2.length() + this.author.getName_show().length() + 1, str3.length() + sb2.length() + this.author.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(absoluteSizeSpan, sb2.length(), sb2.length() + str3.length(), 17);
                    spannableString.setSpan(customForegroundColorSpan, sb2.length(), str3.length() + sb2.length(), 17);
                }
            }
            ArrayList<TbRichTextData> Io = this.dIO.Io();
            if (Io != null && Io.size() > 0) {
                TbRichTextData tbRichTextData2 = Io.get(0);
                if (tbRichTextData2.Iu() != null) {
                    tbRichTextData2.fy(sb.length());
                    tbRichTextData2.Iu().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= Io.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (Io.get(i4) == null || Io.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        TbRichTextVoiceInfo Iv = Io.get(i4).Iv();
                        Io.remove(i4);
                        tbRichTextVoiceInfo = Iv;
                        break;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.a(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.fy(sb.length());
                tbRichTextData.append(spannableString);
                Io.add(0, tbRichTextData);
            }
        }
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        TbRichTextData tbRichTextData;
        TbRichTextVoiceInfo tbRichTextVoiceInfo = null;
        if (tbPageContext != null && this.dIO != null && this.dIO.Io() != null) {
            String str3 = z ? " 楼主" : "";
            String sb = new StringBuilder().toString();
            String name_show = this.author.getName_show();
            if (com.baidu.adp.lib.util.j.aS(this.author.getName_show()) > 14) {
                name_show = al.d(this.author.getName_show(), 14, "...");
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
                Bitmap cS = ai.cS(d.g.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cS);
                if (cS != null) {
                    bitmapDrawable.setBounds(0, 0, cS.getWidth(), cS.getHeight());
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
            ArrayList<TbRichTextData> Io = this.dIO.Io();
            if (Io != null && Io.size() > 0) {
                TbRichTextData tbRichTextData2 = Io.get(0);
                if (tbRichTextData2.Iu() != null) {
                    tbRichTextData2.Iu().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i = 0;
                while (true) {
                    if (i < Io.size()) {
                        if (Io.get(i) == null || Io.get(i).getType() != 512) {
                            i++;
                        } else {
                            tbRichTextVoiceInfo = Io.get(i).Iv();
                            Io.remove(i);
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
                Io.add(0, tbRichTextData);
            }
        }
    }

    protected Drawable g(com.baidu.adp.widget.a.a aVar) {
        Bitmap kX;
        if (aVar == null || (kX = aVar.kX()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(kX);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.f.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.f.ds36));
        return bitmapDrawable;
    }

    public int bsC() {
        return this.gia;
    }

    public void bM(Context context) {
        int type;
        int i;
        int i2;
        if (this.dFI != null) {
            int i3 = -1;
            int size = this.dGy.size();
            if (size > 0) {
                try {
                    i3 = this.dGy.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.dFI.size()) {
                k kVar = this.dFI.get(i4);
                if (k.by(i5, kVar.getType())) {
                    this.dGy.get(size - 1).b(kVar.bL(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.dGy.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.bL(context));
                        this.dGy.add(kVar2);
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
            if (this.dIO != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.dIO.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.dGy == null || this.dGy.size() == 0) {
                bM(context);
            }
            ArrayList<k> arrayList = this.dGy;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.bsk() != null) {
                            sb.append((CharSequence) next.bsk());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(d.l.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(d.l.voice_str));
                    } else if (next.getType() == 2) {
                        String fJ = TbFaceManager.Ew().fJ(next.getText());
                        if (fJ != null) {
                            sb.append("[");
                            sb.append(fJ);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !al.isEmpty(next.bsj())) {
                        sb.append("[").append(next.bsj()).append("]");
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
                this.date = al.r(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.gik = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.dIO = TbRichTextView.b(context, subPostList.content, z);
                if (this.dIO != null) {
                    this.dIO.setPostId(com.baidu.adp.lib.g.b.d(this.id, -1L));
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
                this.date = al.r(this.time);
                this.eDy = jSONObject.optString("time_ex");
                MetaData metaData2 = new MetaData();
                metaData2.parserJson(jSONObject.optJSONObject("author"));
                this.authorId = jSONObject.optString("author_id");
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                this.gin = new be();
                this.gin.parserJson(jSONObject.optJSONObject("from_forum"));
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                if (this.author != null && context != null) {
                    this.giq = this.author.getUserName() + context.getResources().getString(d.l.somebodys_portrait);
                    this.gir = String.format(TbadkCoreApplication.getInst().getString(d.l.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.gim = new h(jSONObject.optJSONObject("tpoint_post"));
                JSONArray optJSONArray = jSONObject.optJSONArray("content");
                this.gia = jSONObject.optInt("sub_post_number");
                if (context == null) {
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            k kVar = new k();
                            kVar.parserJson(optJSONArray.optJSONObject(i));
                            this.dFI.add(kVar);
                        }
                    }
                } else {
                    this.dIO = TbRichTextView.a(context, optJSONArray, true);
                    if (this.dIO != null) {
                        this.dIO.setPostId(com.baidu.adp.lib.g.b.d(this.id, -1L));
                    }
                }
                if (this.gia > 0) {
                    JSONArray optJSONArray2 = jSONObject.optJSONObject("sub_post_list").optJSONArray("sub_post_list");
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(optJSONArray2.getJSONObject(i2), context);
                        this.gib.add(postData);
                    }
                }
                this.bimg_url = jSONObject.optString("bimg_url");
                JSONObject optJSONObject = jSONObject.optJSONObject("act_post");
                if (optJSONObject != null) {
                    this.gig.parserJson(optJSONObject);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("tail_info");
                if (optJSONObject2 != null) {
                    this.gii = new com.baidu.tbadk.data.a();
                    this.gii.parserJson(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("lbs_info");
                if (optJSONObject3 != null) {
                    this.gij = new com.baidu.tbadk.data.h();
                    this.gij.parserJson(optJSONObject3);
                }
                this.gif.parserJson(jSONObject.optJSONObject("present"));
                this.ZF.setUserMap(this.userMap);
                this.ZF.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                JSONArray optJSONArray3 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray3 != null) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        com.baidu.tbadk.data.a aVar = new com.baidu.tbadk.data.a();
                        aVar.parserJson(optJSONArray3.getJSONObject(i3));
                        this.aao.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("agree");
                if (optJSONObject4 != null) {
                    this.giv = optJSONObject4.optLong("agree_num", 0L);
                    this.giw = optJSONObject4.optLong("has_agree", 0L) == 1;
                    this.giu = true;
                } else {
                    this.giu = false;
                }
                this.giB = jSONObject.optInt("is_post_visible") == 1;
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
                this.date = al.r(this.time);
                this.eDy = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                this.gix = post.need_log.intValue() == 1;
                this.gin = new be();
                this.gin.parserProtobuf(post.from_forum);
                if (this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) {
                    this.author.parserProtobuf(post.author);
                }
                if (this.author != null && context != null) {
                    this.giq = this.author.getUserName() + context.getResources().getString(d.l.somebodys_portrait);
                    this.gir = String.format(TbadkCoreApplication.getInst().getString(d.l.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.gih = post.is_ntitle.intValue() == 1;
                this.gia = post.sub_post_number.intValue();
                this.gim = new h(post.tpoint_post);
                this.dIO = TbRichTextView.b(context, post.content, true);
                if (this.dIO != null) {
                    this.dIO.setPostId(com.baidu.adp.lib.g.b.d(this.id, -1L));
                    this.dIO.fx(this.floor_num);
                    if (this.author != null) {
                        this.dIO.setAuthorId(this.author.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.gik = subPostList.is_giftpost.intValue() == 1;
                            postData.setUserMap(this.userMap);
                            postData.a(subPostList, context);
                            this.gib.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.gig.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.gii = new com.baidu.tbadk.data.a();
                    this.gii.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.gij = new com.baidu.tbadk.data.h();
                    this.gij.a(post.lbs_info);
                }
                this.aac = post.storecount.intValue();
                this.gif.a(post.present);
                this.ZF.setUserMap(this.userMap);
                this.ZF.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.eWC = new SmallTailInfo();
                    this.eWC.id = post.signature.signature_id.intValue();
                    this.eWC.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.eWC.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.eWC.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.eWC.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.a aVar = new com.baidu.tbadk.data.a();
                        aVar.a(post.ext_tails.get(i2));
                        this.aao.add(aVar);
                    }
                }
                this.aaq = post.skin_info;
                this.aat = post.lego_card;
                this.git = post.tpoint_post;
                if (post.agree != null) {
                    this.giu = true;
                    this.giw = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.giv = post.agree.agree_num.longValue();
                    } else {
                        this.giv = 0L;
                    }
                } else {
                    this.giu = false;
                }
                this.giB = post.is_post_visible.intValue() == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int eUP;

        public CustomForegroundColorSpan(int i) {
            super(ai.getColor(i));
            this.eUP = i;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ai.getColor(this.eUP));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> giH;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.giH = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ai.getColor(d.e.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.giH != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.giH.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String bO(Context context) {
        ArrayList<TbRichTextData> Io;
        if (this.dIO == null || (Io = this.dIO.Io()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = Io.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.Iu().toString());
            } else if (next.getType() == 17) {
                String str = next.Iy().mGifInfo.mSharpText;
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

    public PreLoadImageInfo bsD() {
        ArrayList<TbRichTextData> Io;
        if (this.dIO != null && (Io = this.dIO.Io()) != null) {
            Iterator<TbRichTextData> it = Io.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.It().getWidth();
                    preLoadImageInfo.height = next.It().getHeight();
                    preLoadImageInfo.imgUrl = next.It().II();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 1536) {
                    if (next.ID() == null || TextUtils.isEmpty(next.ID().url)) {
                        return null;
                    }
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.imgUrl = next.ID().url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String bsE() {
        j bsb;
        PreLoadImageInfo bsD = bsD();
        if (bsD != null && !StringUtils.isNull(bsD.imgUrl)) {
            return bsD.imgUrl;
        }
        if (this.gim != null && (bsb = this.gim.bsb()) != null && !StringUtils.isNull(bsb.bsh())) {
            return bsb.bsh();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ad
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> Io;
        if (this.dIO == null || (Io = this.dIO.Io()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = Io.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.It().getWidth();
                preLoadImageInfo.height = next.It().getHeight();
                preLoadImageInfo.imgUrl = next.It().II();
                preLoadImageInfo.procType = 17;
                arrayList.add(preLoadImageInfo);
            } else if (next.Iy() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.Iy().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.Iy().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.Iy();
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
        if (this.ghZ == 52) {
            return ghX;
        }
        if (this.ghZ == 2) {
            return ghP;
        }
        if (this.ghZ == 1) {
            return aar;
        }
        if (this.ghZ == 36) {
            return ghQ;
        }
        if (this.ghZ == 40 || this.ghZ == 50) {
            return Zd;
        }
        if (this.ghZ == 41) {
            return ghU;
        }
        if (bsy() == 1) {
            return ghN;
        }
        return ghO;
    }

    public void setPostType(int i) {
        this.ghZ = i;
    }

    public as bsF() {
        return this.gif;
    }

    public void a(as asVar) {
        this.gif = asVar;
    }

    public h bsG() {
        return this.gim;
    }

    public com.baidu.tbadk.widget.richText.e Ix() {
        if (this.gip != null) {
            return this.gip;
        }
        if (this.dIO != null && u.u(this.dIO.Io()) > 0) {
            Iterator<TbRichTextData> it = this.dIO.Io().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.gip = next.Ix();
                    return this.gip;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo Iv() {
        if (this.apg != null) {
            return this.apg;
        }
        if (this.dIO != null && u.u(this.dIO.Io()) > 0) {
            Iterator<TbRichTextData> it = this.dIO.Io().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.apg = next.Iv();
                    return this.apg;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.tbadk.data.a> bsH() {
        return this.aao;
    }

    public String bsI() {
        return this.giq;
    }

    public String bsJ() {
        return this.gir;
    }

    public String sA() {
        return this.aat;
    }

    public void sD() {
        if (this.ZS == 0) {
            this.ZS = 1;
        }
    }

    public long bsK() {
        return this.giv;
    }

    public void cT(long j) {
        this.giv = j;
    }

    public boolean bsL() {
        return this.giw;
    }

    public void my(boolean z) {
        this.giw = z;
    }

    public be bsM() {
        return this.gin;
    }
}
