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
    private SkinInfo YU;
    private String YX;
    private TbRichTextVoiceInfo anN;
    @Deprecated
    private String authorId;
    private String bimg_url;
    private String eCl;
    private SmallTailInfo eVp;
    private ArrayList<PostData> ggQ;
    private com.baidu.tbadk.data.a ggW;
    private com.baidu.tbadk.data.h ggX;
    private h gha;
    private be ghb;
    private com.baidu.tbadk.widget.richText.e ghd;
    private String ghe;
    private String ghf;
    private TPointPost ghh;
    public int ghm;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId ggC = BdUniqueId.gen();
    public static final BdUniqueId ggD = BdUniqueId.gen();
    public static final BdUniqueId ggE = BdUniqueId.gen();
    public static final BdUniqueId YV = BdUniqueId.gen();
    public static final BdUniqueId ggF = BdUniqueId.gen();
    public static final BdUniqueId XH = BdUniqueId.gen();
    public static final BdUniqueId ggG = BdUniqueId.gen();
    public static final BdUniqueId ggH = BdUniqueId.gen();
    public static final BdUniqueId ggI = BdUniqueId.gen();
    public static final BdUniqueId ggJ = BdUniqueId.gen();
    public static final BdUniqueId ggK = BdUniqueId.gen();
    public static final BdUniqueId eDh = BdUniqueId.gen();
    public static final BdUniqueId ggL = BdUniqueId.gen();
    public static final BdUniqueId ggM = BdUniqueId.gen();
    public static boolean ggN = false;
    private int ggO = 0;
    private boolean ggR = false;
    private ArrayList<PostData> ggS = null;
    private TbRichText dHx = null;
    private boolean ggV = false;
    private boolean ggY = false;
    private boolean ggZ = false;
    public boolean ghc = false;
    public int Yw = 0;
    public boolean ghg = false;
    private boolean ghi = false;
    private long ghj = 0;
    private boolean ghk = false;
    public boolean ghl = false;
    public boolean ghn = false;
    public boolean gho = true;
    public boolean crt = false;
    public boolean ghp = false;
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData author = new MetaData();
    private ArrayList<k> dEr = new ArrayList<>();
    private ArrayList<k> dFh = new ArrayList<>();
    private int ggP = 0;
    private int YG = 0;
    private PraiseData Yj = new PraiseData();
    private as ggT = new as();
    private c ggU = new c();
    private ArrayList<com.baidu.tbadk.data.a> YS = new ArrayList<>();

    public PostData() {
        this.ggQ = null;
        this.ghm = 0;
        this.ggQ = new ArrayList<>();
        this.ghm = 0;
    }

    public ArrayList<PostData> bsl() {
        return this.ggS;
    }

    public void z(PostData postData) {
        if (postData != null) {
            if (this.ggS == null) {
                this.ggS = new ArrayList<>();
                if (u.u(this.ggQ) > 2) {
                    this.ggS.addAll(u.a(this.ggQ, 0, 2));
                } else {
                    this.ggS.addAll(this.ggQ);
                }
            }
            this.ggS.add(postData);
        }
    }

    public void A(PostData postData) {
        if (postData != null && this.ggQ != null) {
            this.ggQ.add(postData);
            bsp();
        }
    }

    public void rW(String str) {
        if (this.ggS != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.ggS.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.ggS.remove(next);
                    return;
                }
            }
        }
    }

    public void mw(boolean z) {
        this.ggR = z;
    }

    public boolean bsm() {
        return this.ggR;
    }

    public c bsn() {
        return this.ggU;
    }

    public ArrayList<PostData> bso() {
        return this.ggQ;
    }

    public void bsp() {
        this.ggP++;
    }

    public void bsq() {
        this.ggP--;
    }

    public void ti(int i) {
        this.ggP = i;
    }

    public boolean isGiftPost() {
        return this.ggY;
    }

    public void setIsGiftPost(boolean z) {
        this.ggY = z;
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

    public String aOK() {
        return this.eCl;
    }

    public int bsr() {
        return this.floor_num;
    }

    public void tj(int i) {
        this.floor_num = i;
    }

    public boolean bss() {
        return this.ggZ;
    }

    public void mx(boolean z) {
        this.ggZ = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = al.r(j);
    }

    public String bst() {
        return this.date;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public void a(PraiseData praiseData) {
        this.Yj = praiseData;
    }

    public TbRichText aAE() {
        return this.dHx;
    }

    public void g(TbRichText tbRichText) {
        this.dHx = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo aVx() {
        return this.eVp;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.eVp = smallTailInfo;
    }

    public com.baidu.tbadk.data.h bsu() {
        return this.ggX;
    }

    public SkinInfo rQ() {
        return this.YU;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.dHx != null && this.dHx.Ig() != null) {
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
                            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fJ().a(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.f.c.fJ().a(next.getIcon(), 21, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.f.b
                                    public void onLoaded(com.baidu.adp.widget.a.a aVar2, String str4, int i) {
                                        super.onLoaded((C01221) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.kO()) {
                                            cVar2.setDrawable(PostData.this.g(aVar2));
                                            PostData.this.dHx.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.g(aVar);
                        }
                    }, 0, 1);
                    cVar.d(0, 0, TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.f.ds32), TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.f.ds32));
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
                Bitmap cQ = ai.cQ(d.g.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cQ);
                if (cQ != null) {
                    bitmapDrawable.setBounds(0, 0, cQ.getWidth(), cQ.getHeight());
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
            ArrayList<TbRichTextData> Ig = this.dHx.Ig();
            if (Ig != null && Ig.size() > 0) {
                TbRichTextData tbRichTextData2 = Ig.get(0);
                if (tbRichTextData2.In() != null) {
                    tbRichTextData2.fw(sb.length());
                    tbRichTextData2.In().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= Ig.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (Ig.get(i4) == null || Ig.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        TbRichTextVoiceInfo Io = Ig.get(i4).Io();
                        Ig.remove(i4);
                        tbRichTextVoiceInfo = Io;
                        break;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.a(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.fw(sb.length());
                tbRichTextData.append(spannableString);
                Ig.add(0, tbRichTextData);
            }
        }
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        TbRichTextData tbRichTextData;
        TbRichTextVoiceInfo tbRichTextVoiceInfo = null;
        if (tbPageContext != null && this.dHx != null && this.dHx.Ig() != null) {
            String str3 = z ? " 楼主" : "";
            String sb = new StringBuilder().toString();
            String name_show = this.author.getName_show();
            if (com.baidu.adp.lib.util.j.aM(this.author.getName_show()) > 14) {
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
                Bitmap cQ = ai.cQ(d.g.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cQ);
                if (cQ != null) {
                    bitmapDrawable.setBounds(0, 0, cQ.getWidth(), cQ.getHeight());
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
            ArrayList<TbRichTextData> Ig = this.dHx.Ig();
            if (Ig != null && Ig.size() > 0) {
                TbRichTextData tbRichTextData2 = Ig.get(0);
                if (tbRichTextData2.In() != null) {
                    tbRichTextData2.In().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i = 0;
                while (true) {
                    if (i < Ig.size()) {
                        if (Ig.get(i) == null || Ig.get(i).getType() != 512) {
                            i++;
                        } else {
                            tbRichTextVoiceInfo = Ig.get(i).Io();
                            Ig.remove(i);
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
                Ig.add(0, tbRichTextData);
            }
        }
    }

    protected Drawable g(com.baidu.adp.widget.a.a aVar) {
        Bitmap kN;
        if (aVar == null || (kN = aVar.kN()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(kN);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.f.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.f.ds36));
        return bitmapDrawable;
    }

    public int bsv() {
        return this.ggP;
    }

    public void bN(Context context) {
        int type;
        int i;
        int i2;
        if (this.dEr != null) {
            int i3 = -1;
            int size = this.dFh.size();
            if (size > 0) {
                try {
                    i3 = this.dFh.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.dEr.size()) {
                k kVar = this.dEr.get(i4);
                if (k.bx(i5, kVar.getType())) {
                    this.dFh.get(size - 1).b(kVar.bM(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.dFh.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.bM(context));
                        this.dFh.add(kVar2);
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

    public void bO(Context context) {
        try {
            if (this.dHx != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.dHx.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.dFh == null || this.dFh.size() == 0) {
                bN(context);
            }
            ArrayList<k> arrayList = this.dFh;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.bsd() != null) {
                            sb.append((CharSequence) next.bsd());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(d.l.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(d.l.voice_str));
                    } else if (next.getType() == 2) {
                        String fD = TbFaceManager.Eo().fD(next.getText());
                        if (fD != null) {
                            sb.append("[");
                            sb.append(fD);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !al.isEmpty(next.bsc())) {
                        sb.append("[").append(next.bsc()).append("]");
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
                this.ggY = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.dHx = TbRichTextView.b(context, subPostList.content, z);
                if (this.dHx != null) {
                    this.dHx.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
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
                this.eCl = jSONObject.optString("time_ex");
                MetaData metaData2 = new MetaData();
                metaData2.parserJson(jSONObject.optJSONObject("author"));
                this.authorId = jSONObject.optString("author_id");
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                this.ghb = new be();
                this.ghb.parserJson(jSONObject.optJSONObject("from_forum"));
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                if (this.author != null && context != null) {
                    this.ghe = this.author.getUserName() + context.getResources().getString(d.l.somebodys_portrait);
                    this.ghf = String.format(TbadkCoreApplication.getInst().getString(d.l.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.gha = new h(jSONObject.optJSONObject("tpoint_post"));
                JSONArray optJSONArray = jSONObject.optJSONArray("content");
                this.ggP = jSONObject.optInt("sub_post_number");
                if (context == null) {
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            k kVar = new k();
                            kVar.parserJson(optJSONArray.optJSONObject(i));
                            this.dEr.add(kVar);
                        }
                    }
                } else {
                    this.dHx = TbRichTextView.a(context, optJSONArray, true);
                    if (this.dHx != null) {
                        this.dHx.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    }
                }
                if (this.ggP > 0) {
                    JSONArray optJSONArray2 = jSONObject.optJSONObject("sub_post_list").optJSONArray("sub_post_list");
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(optJSONArray2.getJSONObject(i2), context);
                        this.ggQ.add(postData);
                    }
                }
                this.bimg_url = jSONObject.optString("bimg_url");
                JSONObject optJSONObject = jSONObject.optJSONObject("act_post");
                if (optJSONObject != null) {
                    this.ggU.parserJson(optJSONObject);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("tail_info");
                if (optJSONObject2 != null) {
                    this.ggW = new com.baidu.tbadk.data.a();
                    this.ggW.parserJson(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("lbs_info");
                if (optJSONObject3 != null) {
                    this.ggX = new com.baidu.tbadk.data.h();
                    this.ggX.parserJson(optJSONObject3);
                }
                this.ggT.parserJson(jSONObject.optJSONObject("present"));
                this.Yj.setUserMap(this.userMap);
                this.Yj.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                JSONArray optJSONArray3 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray3 != null) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        com.baidu.tbadk.data.a aVar = new com.baidu.tbadk.data.a();
                        aVar.parserJson(optJSONArray3.getJSONObject(i3));
                        this.YS.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("agree");
                if (optJSONObject4 != null) {
                    this.ghj = optJSONObject4.optLong("agree_num", 0L);
                    this.ghk = optJSONObject4.optLong("has_agree", 0L) == 1;
                    this.ghi = true;
                } else {
                    this.ghi = false;
                }
                this.ghp = jSONObject.optInt("is_post_visible") == 1;
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
                this.eCl = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                this.ghl = post.need_log.intValue() == 1;
                this.ghb = new be();
                this.ghb.parserProtobuf(post.from_forum);
                if (this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) {
                    this.author.parserProtobuf(post.author);
                }
                if (this.author != null && context != null) {
                    this.ghe = this.author.getUserName() + context.getResources().getString(d.l.somebodys_portrait);
                    this.ghf = String.format(TbadkCoreApplication.getInst().getString(d.l.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.ggV = post.is_ntitle.intValue() == 1;
                this.ggP = post.sub_post_number.intValue();
                this.gha = new h(post.tpoint_post);
                this.dHx = TbRichTextView.b(context, post.content, true);
                if (this.dHx != null) {
                    this.dHx.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.dHx.fv(this.floor_num);
                    if (this.author != null) {
                        this.dHx.setAuthorId(this.author.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.ggY = subPostList.is_giftpost.intValue() == 1;
                            postData.setUserMap(this.userMap);
                            postData.a(subPostList, context);
                            this.ggQ.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.ggU.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.ggW = new com.baidu.tbadk.data.a();
                    this.ggW.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.ggX = new com.baidu.tbadk.data.h();
                    this.ggX.a(post.lbs_info);
                }
                this.YG = post.storecount.intValue();
                this.ggT.a(post.present);
                this.Yj.setUserMap(this.userMap);
                this.Yj.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.eVp = new SmallTailInfo();
                    this.eVp.id = post.signature.signature_id.intValue();
                    this.eVp.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.eVp.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.eVp.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.eVp.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.a aVar = new com.baidu.tbadk.data.a();
                        aVar.a(post.ext_tails.get(i2));
                        this.YS.add(aVar);
                    }
                }
                this.YU = post.skin_info;
                this.YX = post.lego_card;
                this.ghh = post.tpoint_post;
                if (post.agree != null) {
                    this.ghi = true;
                    this.ghk = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.ghj = post.agree.agree_num.longValue();
                    } else {
                        this.ghj = 0L;
                    }
                } else {
                    this.ghi = false;
                }
                this.ghp = post.is_post_visible.intValue() == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int eTC;

        public CustomForegroundColorSpan(int i) {
            super(ai.getColor(i));
            this.eTC = i;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ai.getColor(this.eTC));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> ghv;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.ghv = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ai.getColor(d.e.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.ghv != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.ghv.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String bP(Context context) {
        ArrayList<TbRichTextData> Ig;
        if (this.dHx == null || (Ig = this.dHx.Ig()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = Ig.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.In().toString());
            } else if (next.getType() == 17) {
                String str = next.Ir().mGifInfo.mSharpText;
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

    public PreLoadImageInfo bsw() {
        ArrayList<TbRichTextData> Ig;
        if (this.dHx != null && (Ig = this.dHx.Ig()) != null) {
            Iterator<TbRichTextData> it = Ig.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.Im().getWidth();
                    preLoadImageInfo.height = next.Im().getHeight();
                    preLoadImageInfo.imgUrl = next.Im().IB();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 1536) {
                    if (next.Iw() == null || TextUtils.isEmpty(next.Iw().url)) {
                        return null;
                    }
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.imgUrl = next.Iw().url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String bsx() {
        j brU;
        PreLoadImageInfo bsw = bsw();
        if (bsw != null && !StringUtils.isNull(bsw.imgUrl)) {
            return bsw.imgUrl;
        }
        if (this.gha != null && (brU = this.gha.brU()) != null && !StringUtils.isNull(brU.bsa())) {
            return brU.bsa();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ad
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> Ig;
        if (this.dHx == null || (Ig = this.dHx.Ig()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = Ig.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.Im().getWidth();
                preLoadImageInfo.height = next.Im().getHeight();
                preLoadImageInfo.imgUrl = next.Im().IB();
                preLoadImageInfo.procType = 17;
                arrayList.add(preLoadImageInfo);
            } else if (next.Ir() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.Ir().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.Ir().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.Ir();
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
        if (this.ggO == 52) {
            return ggM;
        }
        if (this.ggO == 2) {
            return ggE;
        }
        if (this.ggO == 1) {
            return YV;
        }
        if (this.ggO == 36) {
            return ggF;
        }
        if (this.ggO == 40 || this.ggO == 50) {
            return XH;
        }
        if (this.ggO == 41) {
            return ggJ;
        }
        if (bsr() == 1) {
            return ggC;
        }
        return ggD;
    }

    public void setPostType(int i) {
        this.ggO = i;
    }

    public as bsy() {
        return this.ggT;
    }

    public void a(as asVar) {
        this.ggT = asVar;
    }

    public h bsz() {
        return this.gha;
    }

    public com.baidu.tbadk.widget.richText.e Iq() {
        if (this.ghd != null) {
            return this.ghd;
        }
        if (this.dHx != null && u.u(this.dHx.Ig()) > 0) {
            Iterator<TbRichTextData> it = this.dHx.Ig().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.ghd = next.Iq();
                    return this.ghd;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo Io() {
        if (this.anN != null) {
            return this.anN;
        }
        if (this.dHx != null && u.u(this.dHx.Ig()) > 0) {
            Iterator<TbRichTextData> it = this.dHx.Ig().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.anN = next.Io();
                    return this.anN;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.tbadk.data.a> bsA() {
        return this.YS;
    }

    public String bsB() {
        return this.ghe;
    }

    public String bsC() {
        return this.ghf;
    }

    public String sq() {
        return this.YX;
    }

    public void st() {
        if (this.Yw == 0) {
            this.Yw = 1;
        }
    }

    public long bsD() {
        return this.ghj;
    }

    public void cT(long j) {
        this.ghj = j;
    }

    public boolean bsE() {
        return this.ghk;
    }

    public void my(boolean z) {
        this.ghk = z;
    }

    public be bsF() {
        return this.ghb;
    }
}
