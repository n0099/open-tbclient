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
    private SkinInfo aas;
    private String aav;
    private TbRichTextVoiceInfo aph;
    @Deprecated
    private String authorId;
    private String bimg_url;
    private String eFs;
    private SmallTailInfo eYv;
    private ArrayList<PostData> gjU;
    private com.baidu.tbadk.data.a gka;
    private com.baidu.tbadk.data.h gkb;
    private h gke;
    private be gkf;
    private com.baidu.tbadk.widget.richText.e gkh;
    private String gki;
    private String gkj;
    private TPointPost gkl;
    public int gkq;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId gjG = BdUniqueId.gen();
    public static final BdUniqueId gjH = BdUniqueId.gen();
    public static final BdUniqueId gjI = BdUniqueId.gen();
    public static final BdUniqueId aat = BdUniqueId.gen();
    public static final BdUniqueId gjJ = BdUniqueId.gen();
    public static final BdUniqueId Zf = BdUniqueId.gen();
    public static final BdUniqueId gjK = BdUniqueId.gen();
    public static final BdUniqueId gjL = BdUniqueId.gen();
    public static final BdUniqueId gjM = BdUniqueId.gen();
    public static final BdUniqueId gjN = BdUniqueId.gen();
    public static final BdUniqueId gjO = BdUniqueId.gen();
    public static final BdUniqueId eGo = BdUniqueId.gen();
    public static final BdUniqueId gjP = BdUniqueId.gen();
    public static final BdUniqueId gjQ = BdUniqueId.gen();
    public static boolean gjR = false;
    private int gjS = 0;
    private boolean gjV = false;
    private ArrayList<PostData> gjW = null;
    private TbRichText dKK = null;
    private boolean gjZ = false;
    private boolean gkc = false;
    private boolean gkd = false;
    public boolean gkg = false;
    public int ZU = 0;
    public boolean gkk = false;
    private boolean gkm = false;
    private long gkn = 0;
    private boolean gko = false;
    public boolean gkp = false;
    public boolean gkr = false;
    public boolean gks = true;
    public boolean ctl = false;
    public boolean gkt = false;
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData author = new MetaData();
    private ArrayList<k> dHF = new ArrayList<>();
    private ArrayList<k> dIu = new ArrayList<>();
    private int gjT = 0;
    private int aae = 0;
    private PraiseData ZH = new PraiseData();
    private as gjX = new as();
    private c gjY = new c();
    private ArrayList<com.baidu.tbadk.data.a> aaq = new ArrayList<>();

    public PostData() {
        this.gjU = null;
        this.gkq = 0;
        this.gjU = new ArrayList<>();
        this.gkq = 0;
    }

    public ArrayList<PostData> bta() {
        return this.gjW;
    }

    public void z(PostData postData) {
        if (postData != null) {
            if (this.gjW == null) {
                this.gjW = new ArrayList<>();
                if (u.u(this.gjU) > 2) {
                    this.gjW.addAll(u.a(this.gjU, 0, 2));
                } else {
                    this.gjW.addAll(this.gjU);
                }
            }
            this.gjW.add(postData);
        }
    }

    public void A(PostData postData) {
        if (postData != null && this.gjU != null) {
            this.gjU.add(postData);
            bte();
        }
    }

    public void sd(String str) {
        if (this.gjW != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.gjW.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.gjW.remove(next);
                    return;
                }
            }
        }
    }

    public void mz(boolean z) {
        this.gjV = z;
    }

    public boolean btb() {
        return this.gjV;
    }

    public c btc() {
        return this.gjY;
    }

    public ArrayList<PostData> btd() {
        return this.gjU;
    }

    public void bte() {
        this.gjT++;
    }

    public void btf() {
        this.gjT--;
    }

    public void tr(int i) {
        this.gjT = i;
    }

    public boolean isGiftPost() {
        return this.gkc;
    }

    public void setIsGiftPost(boolean z) {
        this.gkc = z;
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

    public String aPC() {
        return this.eFs;
    }

    public int btg() {
        return this.floor_num;
    }

    public void ts(int i) {
        this.floor_num = i;
    }

    public boolean bth() {
        return this.gkd;
    }

    public void mA(boolean z) {
        this.gkd = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = al.r(j);
    }

    public String bti() {
        return this.date;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public void a(PraiseData praiseData) {
        this.ZH = praiseData;
    }

    public TbRichText aBw() {
        return this.dKK;
    }

    public void g(TbRichText tbRichText) {
        this.dKK = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo aWp() {
        return this.eYv;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.eYv = smallTailInfo;
    }

    public com.baidu.tbadk.data.h btj() {
        return this.gkb;
    }

    public SkinInfo sa() {
        return this.aas;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.dKK != null && this.dKK.Io() != null) {
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
                                        super.onLoaded((C01221) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.kY()) {
                                            cVar2.setDrawable(PostData.this.g(aVar2));
                                            PostData.this.dKK.isChanged = true;
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
            ArrayList<TbRichTextData> Io = this.dKK.Io();
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
        if (tbPageContext != null && this.dKK != null && this.dKK.Io() != null) {
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
            ArrayList<TbRichTextData> Io = this.dKK.Io();
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

    public int btk() {
        return this.gjT;
    }

    public void bM(Context context) {
        int type;
        int i;
        int i2;
        if (this.dHF != null) {
            int i3 = -1;
            int size = this.dIu.size();
            if (size > 0) {
                try {
                    i3 = this.dIu.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.dHF.size()) {
                k kVar = this.dHF.get(i4);
                if (k.bG(i5, kVar.getType())) {
                    this.dIu.get(size - 1).b(kVar.bL(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.dIu.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.bL(context));
                        this.dIu.add(kVar2);
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
            if (this.dKK != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.dKK.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.dIu == null || this.dIu.size() == 0) {
                bM(context);
            }
            ArrayList<k> arrayList = this.dIu;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.bsS() != null) {
                            sb.append((CharSequence) next.bsS());
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
                    } else if (next.getType() == 11 && !al.isEmpty(next.bsR())) {
                        sb.append("[").append(next.bsR()).append("]");
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
                this.gkc = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.dKK = TbRichTextView.b(context, subPostList.content, z);
                if (this.dKK != null) {
                    this.dKK.setPostId(com.baidu.adp.lib.g.b.d(this.id, -1L));
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
                this.eFs = jSONObject.optString("time_ex");
                MetaData metaData2 = new MetaData();
                metaData2.parserJson(jSONObject.optJSONObject("author"));
                this.authorId = jSONObject.optString("author_id");
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                this.gkf = new be();
                this.gkf.parserJson(jSONObject.optJSONObject("from_forum"));
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                if (this.author != null && context != null) {
                    this.gki = this.author.getUserName() + context.getResources().getString(d.l.somebodys_portrait);
                    this.gkj = String.format(TbadkCoreApplication.getInst().getString(d.l.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.gke = new h(jSONObject.optJSONObject("tpoint_post"));
                JSONArray optJSONArray = jSONObject.optJSONArray("content");
                this.gjT = jSONObject.optInt("sub_post_number");
                if (context == null) {
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            k kVar = new k();
                            kVar.parserJson(optJSONArray.optJSONObject(i));
                            this.dHF.add(kVar);
                        }
                    }
                } else {
                    this.dKK = TbRichTextView.a(context, optJSONArray, true);
                    if (this.dKK != null) {
                        this.dKK.setPostId(com.baidu.adp.lib.g.b.d(this.id, -1L));
                    }
                }
                if (this.gjT > 0) {
                    JSONArray optJSONArray2 = jSONObject.optJSONObject("sub_post_list").optJSONArray("sub_post_list");
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(optJSONArray2.getJSONObject(i2), context);
                        this.gjU.add(postData);
                    }
                }
                this.bimg_url = jSONObject.optString("bimg_url");
                JSONObject optJSONObject = jSONObject.optJSONObject("act_post");
                if (optJSONObject != null) {
                    this.gjY.parserJson(optJSONObject);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("tail_info");
                if (optJSONObject2 != null) {
                    this.gka = new com.baidu.tbadk.data.a();
                    this.gka.parserJson(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("lbs_info");
                if (optJSONObject3 != null) {
                    this.gkb = new com.baidu.tbadk.data.h();
                    this.gkb.parserJson(optJSONObject3);
                }
                this.gjX.parserJson(jSONObject.optJSONObject("present"));
                this.ZH.setUserMap(this.userMap);
                this.ZH.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                JSONArray optJSONArray3 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray3 != null) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        com.baidu.tbadk.data.a aVar = new com.baidu.tbadk.data.a();
                        aVar.parserJson(optJSONArray3.getJSONObject(i3));
                        this.aaq.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("agree");
                if (optJSONObject4 != null) {
                    this.gkn = optJSONObject4.optLong("agree_num", 0L);
                    this.gko = optJSONObject4.optLong("has_agree", 0L) == 1;
                    this.gkm = true;
                } else {
                    this.gkm = false;
                }
                this.gkt = jSONObject.optInt("is_post_visible") == 1;
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
                this.eFs = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                this.gkp = post.need_log.intValue() == 1;
                this.gkf = new be();
                this.gkf.parserProtobuf(post.from_forum);
                if (this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) {
                    this.author.parserProtobuf(post.author);
                }
                if (this.author != null && context != null) {
                    this.gki = this.author.getUserName() + context.getResources().getString(d.l.somebodys_portrait);
                    this.gkj = String.format(TbadkCoreApplication.getInst().getString(d.l.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.gjZ = post.is_ntitle.intValue() == 1;
                this.gjT = post.sub_post_number.intValue();
                this.gke = new h(post.tpoint_post);
                this.dKK = TbRichTextView.b(context, post.content, true);
                if (this.dKK != null) {
                    this.dKK.setPostId(com.baidu.adp.lib.g.b.d(this.id, -1L));
                    this.dKK.fx(this.floor_num);
                    if (this.author != null) {
                        this.dKK.setAuthorId(this.author.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.gkc = subPostList.is_giftpost.intValue() == 1;
                            postData.setUserMap(this.userMap);
                            postData.a(subPostList, context);
                            this.gjU.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.gjY.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.gka = new com.baidu.tbadk.data.a();
                    this.gka.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.gkb = new com.baidu.tbadk.data.h();
                    this.gkb.a(post.lbs_info);
                }
                this.aae = post.storecount.intValue();
                this.gjX.a(post.present);
                this.ZH.setUserMap(this.userMap);
                this.ZH.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.eYv = new SmallTailInfo();
                    this.eYv.id = post.signature.signature_id.intValue();
                    this.eYv.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.eYv.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.eYv.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.eYv.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.a aVar = new com.baidu.tbadk.data.a();
                        aVar.a(post.ext_tails.get(i2));
                        this.aaq.add(aVar);
                    }
                }
                this.aas = post.skin_info;
                this.aav = post.lego_card;
                this.gkl = post.tpoint_post;
                if (post.agree != null) {
                    this.gkm = true;
                    this.gko = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.gkn = post.agree.agree_num.longValue();
                    } else {
                        this.gkn = 0L;
                    }
                } else {
                    this.gkm = false;
                }
                this.gkt = post.is_post_visible.intValue() == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int eWI;

        public CustomForegroundColorSpan(int i) {
            super(ai.getColor(i));
            this.eWI = i;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ai.getColor(this.eWI));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> gkz;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.gkz = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ai.getColor(d.e.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.gkz != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.gkz.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String bO(Context context) {
        ArrayList<TbRichTextData> Io;
        if (this.dKK == null || (Io = this.dKK.Io()) == null) {
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

    public PreLoadImageInfo btl() {
        ArrayList<TbRichTextData> Io;
        if (this.dKK != null && (Io = this.dKK.Io()) != null) {
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

    public String btm() {
        j bsJ;
        PreLoadImageInfo btl = btl();
        if (btl != null && !StringUtils.isNull(btl.imgUrl)) {
            return btl.imgUrl;
        }
        if (this.gke != null && (bsJ = this.gke.bsJ()) != null && !StringUtils.isNull(bsJ.bsP())) {
            return bsJ.bsP();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ad
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> Io;
        if (this.dKK == null || (Io = this.dKK.Io()) == null) {
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
        if (this.gjS == 52) {
            return gjQ;
        }
        if (this.gjS == 2) {
            return gjI;
        }
        if (this.gjS == 1) {
            return aat;
        }
        if (this.gjS == 36) {
            return gjJ;
        }
        if (this.gjS == 40 || this.gjS == 50) {
            return Zf;
        }
        if (this.gjS == 41) {
            return gjN;
        }
        if (btg() == 1) {
            return gjG;
        }
        return gjH;
    }

    public void setPostType(int i) {
        this.gjS = i;
    }

    public as btn() {
        return this.gjX;
    }

    public void a(as asVar) {
        this.gjX = asVar;
    }

    public h bto() {
        return this.gke;
    }

    public com.baidu.tbadk.widget.richText.e Ix() {
        if (this.gkh != null) {
            return this.gkh;
        }
        if (this.dKK != null && u.u(this.dKK.Io()) > 0) {
            Iterator<TbRichTextData> it = this.dKK.Io().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.gkh = next.Ix();
                    return this.gkh;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo Iv() {
        if (this.aph != null) {
            return this.aph;
        }
        if (this.dKK != null && u.u(this.dKK.Io()) > 0) {
            Iterator<TbRichTextData> it = this.dKK.Io().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.aph = next.Iv();
                    return this.aph;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.tbadk.data.a> btp() {
        return this.aaq;
    }

    public String btq() {
        return this.gki;
    }

    public String btr() {
        return this.gkj;
    }

    public String sA() {
        return this.aav;
    }

    public void sD() {
        if (this.ZU == 0) {
            this.ZU = 1;
        }
    }

    public long bts() {
        return this.gkn;
    }

    public void cT(long j) {
        this.gkn = j;
    }

    public boolean btt() {
        return this.gko;
    }

    public void mB(boolean z) {
        this.gko = z;
    }

    public be btu() {
        return this.gkf;
    }
}
