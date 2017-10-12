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
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bc;
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
    private TbRichTextVoiceInfo anS;
    @Deprecated
    private String authorId;
    private String bimg_url;
    private SmallTailInfo eSm;
    private String eyc;
    private ArrayList<PostData> ggY;
    private com.baidu.tbadk.data.a ghe;
    private com.baidu.tbadk.data.g ghf;
    private h ghi;
    private bc ghj;
    public boolean ghl;
    private com.baidu.tbadk.widget.richText.e ghm;
    private String ghn;
    private String gho;
    private TPointPost ghq;
    public int ghu;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId ggH = BdUniqueId.gen();
    public static final BdUniqueId ggI = BdUniqueId.gen();
    public static final BdUniqueId ggJ = BdUniqueId.gen();
    public static final BdUniqueId Zx = BdUniqueId.gen();
    public static final BdUniqueId ggK = BdUniqueId.gen();
    public static final BdUniqueId Yl = BdUniqueId.gen();
    public static final BdUniqueId ggL = BdUniqueId.gen();
    public static final BdUniqueId ggM = BdUniqueId.gen();
    public static final BdUniqueId ggN = BdUniqueId.gen();
    public static final BdUniqueId ggO = BdUniqueId.gen();
    public static final BdUniqueId ggP = BdUniqueId.gen();
    public static final BdUniqueId eza = BdUniqueId.gen();
    public static final BdUniqueId ggQ = BdUniqueId.gen();
    public static final BdUniqueId ggR = BdUniqueId.gen();
    public static final BdUniqueId ggS = BdUniqueId.gen();
    public static boolean ggT = false;
    private int ggU = 0;
    private boolean ggZ = false;
    private ArrayList<PostData> gha = null;
    private TbRichText dOp = null;
    private boolean ghd = false;
    private boolean ghg = false;
    private boolean ghh = false;
    public boolean ghk = false;
    public int YY = 0;
    public boolean ghp = false;
    private boolean ghr = false;
    private long cuI = 0;
    private boolean cuJ = false;
    public boolean ghs = false;
    public boolean ght = false;
    public boolean ghv = false;
    public boolean ghw = true;
    public boolean cBz = false;
    public boolean ghx = false;
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData author = new MetaData();
    private ArrayList<k> ggV = new ArrayList<>();
    private ArrayList<k> ggW = new ArrayList<>();
    private int ggX = 0;
    private int Zi = 0;
    private PraiseData YN = new PraiseData();
    private aq ghb = new aq();
    private c ghc = new c();
    private ArrayList<com.baidu.tbadk.data.a> Zu = new ArrayList<>();

    public PostData() {
        this.ggY = null;
        this.ghu = 0;
        this.ggY = new ArrayList<>();
        this.ghu = 0;
    }

    public ArrayList<PostData> brq() {
        return this.gha;
    }

    public void brr() {
        this.gha.clear();
        this.gha = null;
        this.ggZ = false;
    }

    public void A(PostData postData) {
        if (postData != null) {
            if (this.gha == null) {
                this.gha = new ArrayList<>();
                if (v.t(this.ggY) > 2) {
                    this.gha.addAll(v.a(this.ggY, 0, 2));
                } else {
                    this.gha.addAll(this.ggY);
                }
            }
            this.gha.add(postData);
        }
    }

    public void B(PostData postData) {
        if (postData != null && this.ggY != null) {
            this.ggY.add(postData);
            brv();
        }
    }

    public void rP(String str) {
        if (this.gha != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.gha.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.gha.remove(next);
                    return;
                }
            }
        }
    }

    public void mA(boolean z) {
        this.ggZ = z;
    }

    public boolean brs() {
        return this.ggZ;
    }

    public c brt() {
        return this.ghc;
    }

    public ArrayList<PostData> bru() {
        return this.ggY;
    }

    public void brv() {
        this.ggX++;
    }

    public void brw() {
        this.ggX--;
    }

    public void tA(int i) {
        this.ggX = i;
    }

    public boolean isGiftPost() {
        return this.ghg;
    }

    public void setIsGiftPost(boolean z) {
        this.ghg = z;
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

    public String aMO() {
        return this.eyc;
    }

    public int brx() {
        return this.floor_num;
    }

    public void tB(int i) {
        this.floor_num = i;
    }

    public boolean bry() {
        return this.ghh;
    }

    public void mB(boolean z) {
        this.ghh = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = am.q(j);
    }

    public String brz() {
        return this.date;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public void a(PraiseData praiseData) {
        this.YN = praiseData;
    }

    public TbRichText aCd() {
        return this.dOp;
    }

    public void g(TbRichText tbRichText) {
        this.dOp = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo aTS() {
        return this.eSm;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.eSm = smallTailInfo;
    }

    public com.baidu.tbadk.data.g brA() {
        return this.ghf;
    }

    public SkinInfo rQ() {
        return this.Zw;
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.dOp != null && this.dOp.ID() != null) {
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
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.fJ().a(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.f.c.fJ().a(next.getIcon(), 21, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.f.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((C01271) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.kO()) {
                                            cVar2.setDrawable(PostData.this.i(aVar2));
                                            PostData.this.dOp.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.i(aVar);
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
                Bitmap cR = aj.cR(d.g.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cR);
                if (cR != null) {
                    bitmapDrawable.setBounds(0, 0, cR.getWidth(), cR.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.f.ds2));
                int size = arrayList.size() + this.author.getSealPrefix().length() + 1;
                spannableString.setSpan(iVar, size, size + 1, 17);
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
            ArrayList<TbRichTextData> ID = this.dOp.ID();
            if (ID != null && ID.size() > 0) {
                TbRichTextData tbRichTextData2 = ID.get(0);
                if (tbRichTextData2.IK() != null) {
                    tbRichTextData2.fN(sb.length());
                    tbRichTextData2.IK().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= ID.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (ID.get(i4) == null || ID.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        TbRichTextVoiceInfo IL = ID.get(i4).IL();
                        ID.remove(i4);
                        tbRichTextVoiceInfo = IL;
                        break;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.a(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.fN(sb.length());
                tbRichTextData.append(spannableString);
                ID.add(0, tbRichTextData);
            }
        }
    }

    public void c(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        TbRichTextData tbRichTextData;
        TbRichTextVoiceInfo tbRichTextVoiceInfo = null;
        if (tbPageContext != null && this.dOp != null && this.dOp.ID() != null) {
            String str3 = z ? " 楼主" : "";
            String sb = new StringBuilder().toString();
            String name_show = this.author.getName_show();
            if (com.baidu.adp.lib.util.k.aP(this.author.getName_show()) > 14) {
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
                Bitmap cR = aj.cR(d.g.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cR);
                if (cR != null) {
                    bitmapDrawable.setBounds(0, 0, cR.getWidth(), cR.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.f.ds2));
                int length = this.author.getSealPrefix().length() + 1;
                spannableString.setSpan(iVar, length, length + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str, str2), 0, spannableString.length(), 18);
            if (z) {
                AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.f.ds28));
                CustomForegroundColorSpan customForegroundColorSpan = new CustomForegroundColorSpan(d.e.cp_link_tip_a);
                if (this.author != null) {
                    spannableString.setSpan(absoluteSizeSpan, sb.length() + this.author.getName_show().length() + 1, sb.length() + this.author.getName_show().length() + str3.length(), 17);
                    spannableString.setSpan(customForegroundColorSpan, sb.length() + this.author.getName_show().length() + 1, str3.length() + sb.length() + this.author.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(absoluteSizeSpan, sb.length(), sb.length() + str3.length(), 17);
                    spannableString.setSpan(customForegroundColorSpan, sb.length(), str3.length() + sb.length(), 17);
                }
            }
            ArrayList<TbRichTextData> ID = this.dOp.ID();
            if (ID != null && ID.size() > 0) {
                TbRichTextData tbRichTextData2 = ID.get(0);
                if (tbRichTextData2.IK() != null) {
                    tbRichTextData2.IK().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i = 0;
                while (true) {
                    if (i < ID.size()) {
                        if (ID.get(i) == null || ID.get(i).getType() != 512) {
                            i++;
                        } else {
                            tbRichTextVoiceInfo = ID.get(i).IL();
                            ID.remove(i);
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
                ID.add(0, tbRichTextData);
            }
        }
    }

    protected Drawable i(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap kN;
        if (aVar == null || (kN = aVar.kN()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(kN);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.f.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.f.ds36));
        return bitmapDrawable;
    }

    public int brB() {
        return this.ggX;
    }

    public void bW(Context context) {
        int type;
        int i;
        int i2;
        if (this.ggV != null) {
            int i3 = -1;
            int size = this.ggW.size();
            if (size > 0) {
                try {
                    i3 = this.ggW.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.ggV.size()) {
                k kVar = this.ggV.get(i4);
                if (k.bT(i5, kVar.getType())) {
                    this.ggW.get(size - 1).b(kVar.bV(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.ggW.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.bV(context));
                        this.ggW.add(kVar2);
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

    public void bX(Context context) {
        try {
            if (this.dOp != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.dOp.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.ggW == null || this.ggW.size() == 0) {
                bW(context);
            }
            ArrayList<k> arrayList = this.ggW;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.bri() != null) {
                            sb.append((CharSequence) next.bri());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(d.l.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(d.l.voice_str));
                    } else if (next.getType() == 2) {
                        String fB = TbFaceManager.DY().fB(next.getText());
                        if (fB != null) {
                            sb.append("[");
                            sb.append(fB);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !am.isEmpty(next.brh())) {
                        sb.append("[").append(next.brh()).append("]");
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
                this.date = am.q(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.ghg = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.dOp = TbRichTextView.a(context, subPostList.content, z);
                if (this.dOp != null) {
                    this.dOp.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
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
                this.date = am.q(this.time);
                this.eyc = jSONObject.optString("time_ex");
                MetaData metaData2 = new MetaData();
                metaData2.parserJson(jSONObject.optJSONObject("author"));
                this.authorId = jSONObject.optString("author_id");
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                this.ghj = new bc();
                this.ghj.parserJson(jSONObject.optJSONObject("from_forum"));
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                if (this.author != null && context != null) {
                    this.ghn = this.author.getUserName() + context.getResources().getString(d.l.somebodys_portrait);
                    this.gho = String.format(TbadkCoreApplication.getInst().getString(d.l.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.ghi = new h(jSONObject.optJSONObject("tpoint_post"));
                JSONArray optJSONArray = jSONObject.optJSONArray("content");
                this.ggX = jSONObject.optInt("sub_post_number");
                if (context == null) {
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            k kVar = new k();
                            kVar.parserJson(optJSONArray.optJSONObject(i));
                            this.ggV.add(kVar);
                        }
                    }
                } else {
                    this.dOp = TbRichTextView.a(context, optJSONArray, true);
                    if (this.dOp != null) {
                        this.dOp.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    }
                }
                if (this.ggX > 0) {
                    JSONArray optJSONArray2 = jSONObject.optJSONObject("sub_post_list").optJSONArray("sub_post_list");
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(optJSONArray2.getJSONObject(i2), context);
                        this.ggY.add(postData);
                    }
                }
                this.bimg_url = jSONObject.optString("bimg_url");
                JSONObject optJSONObject = jSONObject.optJSONObject("act_post");
                if (optJSONObject != null) {
                    this.ghc.parserJson(optJSONObject);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("tail_info");
                if (optJSONObject2 != null) {
                    this.ghe = new com.baidu.tbadk.data.a();
                    this.ghe.parserJson(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("lbs_info");
                if (optJSONObject3 != null) {
                    this.ghf = new com.baidu.tbadk.data.g();
                    this.ghf.parserJson(optJSONObject3);
                }
                this.ghb.parserJson(jSONObject.optJSONObject("present"));
                this.YN.setUserMap(this.userMap);
                this.YN.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
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
                    this.cuI = optJSONObject4.optLong("agree_num", 0L);
                    this.cuJ = optJSONObject4.optLong("has_agree", 0L) == 1;
                    this.ghr = true;
                } else {
                    this.ghr = false;
                }
                this.ghx = jSONObject.optInt("is_post_visible") == 1;
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
                this.date = am.q(this.time);
                this.eyc = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                this.ghs = post.need_log.intValue() == 1;
                this.ght = post.img_num_abtest.intValue() == 1;
                this.ghj = new bc();
                this.ghj.parserProtobuf(post.from_forum);
                if (this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) {
                    this.author.parserProtobuf(post.author);
                }
                if (this.author != null && context != null) {
                    this.ghn = this.author.getUserName() + context.getResources().getString(d.l.somebodys_portrait);
                    this.gho = String.format(TbadkCoreApplication.getInst().getString(d.l.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.ghd = post.is_ntitle.intValue() == 1;
                this.ggX = post.sub_post_number.intValue();
                this.ghi = new h(post.tpoint_post);
                this.dOp = TbRichTextView.a(context, post.content, true);
                if (this.dOp != null) {
                    this.dOp.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.dOp.fM(this.floor_num);
                    if (this.author != null) {
                        this.dOp.setAuthorId(this.author.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.ghg = subPostList.is_giftpost.intValue() == 1;
                            postData.setUserMap(this.userMap);
                            postData.a(subPostList, context);
                            this.ggY.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.ghc.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.ghe = new com.baidu.tbadk.data.a();
                    this.ghe.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.ghf = new com.baidu.tbadk.data.g();
                    this.ghf.a(post.lbs_info);
                }
                this.Zi = post.storecount.intValue();
                this.ghb.a(post.present);
                this.YN.setUserMap(this.userMap);
                this.YN.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.eSm = new SmallTailInfo();
                    this.eSm.id = post.signature.signature_id.intValue();
                    this.eSm.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.eSm.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.eSm.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.eSm.updateShowInfo();
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
                this.ghq = post.tpoint_post;
                if (post.agree != null) {
                    this.ghr = true;
                    this.cuJ = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.cuI = post.agree.agree_num.longValue();
                    } else {
                        this.cuI = 0L;
                    }
                } else {
                    this.ghr = false;
                }
                this.ghx = post.is_post_visible.intValue() == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int eQt;

        public CustomForegroundColorSpan(int i) {
            super(aj.getColor(i));
            this.eQt = i;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aj.getColor(this.eQt));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> ghD;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.ghD = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aj.getColor(d.e.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.ghD != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.ghD.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String bY(Context context) {
        ArrayList<TbRichTextData> ID;
        if (this.dOp == null || (ID = this.dOp.ID()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = ID.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.IK().toString());
            } else if (next.getType() == 17) {
                String str = next.IO().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(d.l.editor_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(d.l.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(d.l.msglist_video) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public PreLoadImageInfo brC() {
        ArrayList<TbRichTextData> ID;
        if (this.dOp != null && (ID = this.dOp.ID()) != null) {
            Iterator<TbRichTextData> it = ID.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.IJ().getWidth();
                    preLoadImageInfo.height = next.IJ().getHeight();
                    preLoadImageInfo.imgUrl = next.IJ().IX();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                }
            }
            return null;
        }
        return null;
    }

    public String brD() {
        j bqZ;
        PreLoadImageInfo brC = brC();
        if (brC != null && !StringUtils.isNull(brC.imgUrl)) {
            return brC.imgUrl;
        }
        if (this.ghi != null && (bqZ = this.ghi.bqZ()) != null && !StringUtils.isNull(bqZ.brf())) {
            return bqZ.brf();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> ID;
        if (this.dOp == null || (ID = this.dOp.ID()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = ID.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.IJ().getWidth();
                preLoadImageInfo.height = next.IJ().getHeight();
                preLoadImageInfo.imgUrl = next.IJ().IX();
                preLoadImageInfo.procType = 17;
                arrayList.add(preLoadImageInfo);
            } else if (next.IO() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.IO().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.IO().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.IO();
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
        if (this.ggU == 52) {
            return ggR;
        }
        if (this.ggU == 2) {
            return ggJ;
        }
        if (this.ggU == 1) {
            return Zx;
        }
        if (this.ggU == 36) {
            return ggK;
        }
        if (this.ggU == 40 || this.ggU == 50) {
            return Yl;
        }
        if (this.ggU == 41) {
            return ggO;
        }
        if (this.ggU == 53) {
            return ggS;
        }
        if (brx() == 1) {
            return ggH;
        }
        return ggI;
    }

    public void setPostType(int i) {
        this.ggU = i;
    }

    public aq brE() {
        return this.ghb;
    }

    public void a(aq aqVar) {
        this.ghb = aqVar;
    }

    public h brF() {
        return this.ghi;
    }

    public com.baidu.tbadk.widget.richText.e IN() {
        if (this.ghm != null) {
            return this.ghm;
        }
        if (this.dOp != null && v.t(this.dOp.ID()) > 0) {
            Iterator<TbRichTextData> it = this.dOp.ID().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.ghm = next.IN();
                    return this.ghm;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo IL() {
        if (this.anS != null) {
            return this.anS;
        }
        if (this.dOp != null && v.t(this.dOp.ID()) > 0) {
            Iterator<TbRichTextData> it = this.dOp.ID().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.anS = next.IL();
                    return this.anS;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.tbadk.data.a> brG() {
        return this.Zu;
    }

    public String brH() {
        return this.ghn;
    }

    public String brI() {
        return this.gho;
    }

    public String sq() {
        return this.Zz;
    }

    public void st() {
        if (this.YY == 0) {
            this.YY = 1;
        }
    }

    public long brJ() {
        return this.cuI;
    }

    public void cL(long j) {
        this.cuI = j;
    }

    public boolean brK() {
        return this.cuJ;
    }

    public void mC(boolean z) {
        this.cuJ = z;
    }

    public bc brL() {
        return this.ghj;
    }
}
