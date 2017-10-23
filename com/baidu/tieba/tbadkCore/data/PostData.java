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
    private SkinInfo Zk;
    private String Zn;
    private TbRichTextVoiceInfo anG;
    @Deprecated
    private String authorId;
    private String bimg_url;
    private SmallTailInfo eRY;
    private String exO;
    private ArrayList<PostData> ggK;
    private com.baidu.tbadk.data.a ggQ;
    private com.baidu.tbadk.data.g ggR;
    private h ggU;
    private bc ggV;
    public boolean ggX;
    private com.baidu.tbadk.widget.richText.e ggY;
    private String ggZ;
    private String gha;
    private TPointPost ghc;
    public int ghg;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId ggt = BdUniqueId.gen();
    public static final BdUniqueId ggu = BdUniqueId.gen();
    public static final BdUniqueId ggv = BdUniqueId.gen();
    public static final BdUniqueId Zl = BdUniqueId.gen();
    public static final BdUniqueId ggw = BdUniqueId.gen();
    public static final BdUniqueId XZ = BdUniqueId.gen();
    public static final BdUniqueId ggx = BdUniqueId.gen();
    public static final BdUniqueId ggy = BdUniqueId.gen();
    public static final BdUniqueId ggz = BdUniqueId.gen();
    public static final BdUniqueId ggA = BdUniqueId.gen();
    public static final BdUniqueId ggB = BdUniqueId.gen();
    public static final BdUniqueId eyM = BdUniqueId.gen();
    public static final BdUniqueId ggC = BdUniqueId.gen();
    public static final BdUniqueId ggD = BdUniqueId.gen();
    public static final BdUniqueId ggE = BdUniqueId.gen();
    public static boolean ggF = false;
    private int ggG = 0;
    private boolean ggL = false;
    private ArrayList<PostData> ggM = null;
    private TbRichText dOb = null;
    private boolean ggP = false;
    private boolean ggS = false;
    private boolean ggT = false;
    public boolean ggW = false;
    public int YM = 0;
    public boolean ghb = false;
    private boolean ghd = false;
    private long cuw = 0;
    private boolean cux = false;
    public boolean ghe = false;
    public boolean ghf = false;
    public boolean ghh = false;
    public boolean ghi = true;
    public boolean cBn = false;
    public boolean ghj = false;
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData author = new MetaData();
    private ArrayList<k> ggH = new ArrayList<>();
    private ArrayList<k> ggI = new ArrayList<>();
    private int ggJ = 0;
    private int YW = 0;
    private PraiseData YB = new PraiseData();
    private aq ggN = new aq();
    private c ggO = new c();
    private ArrayList<com.baidu.tbadk.data.a> Zi = new ArrayList<>();

    public PostData() {
        this.ggK = null;
        this.ghg = 0;
        this.ggK = new ArrayList<>();
        this.ghg = 0;
    }

    public ArrayList<PostData> brj() {
        return this.ggM;
    }

    public void brk() {
        this.ggM.clear();
        this.ggM = null;
        this.ggL = false;
    }

    public void A(PostData postData) {
        if (postData != null) {
            if (this.ggM == null) {
                this.ggM = new ArrayList<>();
                if (v.t(this.ggK) > 2) {
                    this.ggM.addAll(v.a(this.ggK, 0, 2));
                } else {
                    this.ggM.addAll(this.ggK);
                }
            }
            this.ggM.add(postData);
        }
    }

    public void B(PostData postData) {
        if (postData != null && this.ggK != null) {
            this.ggK.add(postData);
            bro();
        }
    }

    public void rO(String str) {
        if (this.ggM != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.ggM.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.ggM.remove(next);
                    return;
                }
            }
        }
    }

    public void mz(boolean z) {
        this.ggL = z;
    }

    public boolean brl() {
        return this.ggL;
    }

    public c brm() {
        return this.ggO;
    }

    public ArrayList<PostData> brn() {
        return this.ggK;
    }

    public void bro() {
        this.ggJ++;
    }

    public void brp() {
        this.ggJ--;
    }

    public void tz(int i) {
        this.ggJ = i;
    }

    public boolean isGiftPost() {
        return this.ggS;
    }

    public void setIsGiftPost(boolean z) {
        this.ggS = z;
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

    public String aMJ() {
        return this.exO;
    }

    public int brq() {
        return this.floor_num;
    }

    public void tA(int i) {
        this.floor_num = i;
    }

    public boolean brr() {
        return this.ggT;
    }

    public void mA(boolean z) {
        this.ggT = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = am.r(j);
    }

    public String brs() {
        return this.date;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public void a(PraiseData praiseData) {
        this.YB = praiseData;
    }

    public TbRichText aBY() {
        return this.dOb;
    }

    public void g(TbRichText tbRichText) {
        this.dOb = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo aTN() {
        return this.eRY;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.eRY = smallTailInfo;
    }

    public com.baidu.tbadk.data.g brt() {
        return this.ggR;
    }

    public SkinInfo rJ() {
        return this.Zk;
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.dOb != null && this.dOb.Ix() != null) {
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
                                            PostData.this.dOb.isChanged = true;
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
                Bitmap cQ = aj.cQ(d.g.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cQ);
                if (cQ != null) {
                    bitmapDrawable.setBounds(0, 0, cQ.getWidth(), cQ.getHeight());
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
            ArrayList<TbRichTextData> Ix = this.dOb.Ix();
            if (Ix != null && Ix.size() > 0) {
                TbRichTextData tbRichTextData2 = Ix.get(0);
                if (tbRichTextData2.IE() != null) {
                    tbRichTextData2.fM(sb.length());
                    tbRichTextData2.IE().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= Ix.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (Ix.get(i4) == null || Ix.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        TbRichTextVoiceInfo IF = Ix.get(i4).IF();
                        Ix.remove(i4);
                        tbRichTextVoiceInfo = IF;
                        break;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.a(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.fM(sb.length());
                tbRichTextData.append(spannableString);
                Ix.add(0, tbRichTextData);
            }
        }
    }

    public void c(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        TbRichTextData tbRichTextData;
        TbRichTextVoiceInfo tbRichTextVoiceInfo = null;
        if (tbPageContext != null && this.dOb != null && this.dOb.Ix() != null) {
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
                Bitmap cQ = aj.cQ(d.g.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cQ);
                if (cQ != null) {
                    bitmapDrawable.setBounds(0, 0, cQ.getWidth(), cQ.getHeight());
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
            ArrayList<TbRichTextData> Ix = this.dOb.Ix();
            if (Ix != null && Ix.size() > 0) {
                TbRichTextData tbRichTextData2 = Ix.get(0);
                if (tbRichTextData2.IE() != null) {
                    tbRichTextData2.IE().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i = 0;
                while (true) {
                    if (i < Ix.size()) {
                        if (Ix.get(i) == null || Ix.get(i).getType() != 512) {
                            i++;
                        } else {
                            tbRichTextVoiceInfo = Ix.get(i).IF();
                            Ix.remove(i);
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
                Ix.add(0, tbRichTextData);
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

    public int bru() {
        return this.ggJ;
    }

    public void bV(Context context) {
        int type;
        int i;
        int i2;
        if (this.ggH != null) {
            int i3 = -1;
            int size = this.ggI.size();
            if (size > 0) {
                try {
                    i3 = this.ggI.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.ggH.size()) {
                k kVar = this.ggH.get(i4);
                if (k.bT(i5, kVar.getType())) {
                    this.ggI.get(size - 1).b(kVar.bU(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.ggI.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.bU(context));
                        this.ggI.add(kVar2);
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

    public void bW(Context context) {
        try {
            if (this.dOb != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.dOb.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.ggI == null || this.ggI.size() == 0) {
                bV(context);
            }
            ArrayList<k> arrayList = this.ggI;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.brb() != null) {
                            sb.append((CharSequence) next.brb());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(d.l.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(d.l.voice_str));
                    } else if (next.getType() == 2) {
                        String fA = TbFaceManager.DS().fA(next.getText());
                        if (fA != null) {
                            sb.append("[");
                            sb.append(fA);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !am.isEmpty(next.bra())) {
                        sb.append("[").append(next.bra()).append("]");
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
                this.ggS = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.dOb = TbRichTextView.a(context, subPostList.content, z);
                if (this.dOb != null) {
                    this.dOb.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
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
                this.exO = jSONObject.optString("time_ex");
                MetaData metaData2 = new MetaData();
                metaData2.parserJson(jSONObject.optJSONObject("author"));
                this.authorId = jSONObject.optString("author_id");
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                this.ggV = new bc();
                this.ggV.parserJson(jSONObject.optJSONObject("from_forum"));
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                if (this.author != null && context != null) {
                    this.ggZ = this.author.getUserName() + context.getResources().getString(d.l.somebodys_portrait);
                    this.gha = String.format(TbadkCoreApplication.getInst().getString(d.l.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.ggU = new h(jSONObject.optJSONObject("tpoint_post"));
                JSONArray optJSONArray = jSONObject.optJSONArray("content");
                this.ggJ = jSONObject.optInt("sub_post_number");
                if (context == null) {
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            k kVar = new k();
                            kVar.parserJson(optJSONArray.optJSONObject(i));
                            this.ggH.add(kVar);
                        }
                    }
                } else {
                    this.dOb = TbRichTextView.a(context, optJSONArray, true);
                    if (this.dOb != null) {
                        this.dOb.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    }
                }
                if (this.ggJ > 0) {
                    JSONArray optJSONArray2 = jSONObject.optJSONObject("sub_post_list").optJSONArray("sub_post_list");
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(optJSONArray2.getJSONObject(i2), context);
                        this.ggK.add(postData);
                    }
                }
                this.bimg_url = jSONObject.optString("bimg_url");
                JSONObject optJSONObject = jSONObject.optJSONObject("act_post");
                if (optJSONObject != null) {
                    this.ggO.parserJson(optJSONObject);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("tail_info");
                if (optJSONObject2 != null) {
                    this.ggQ = new com.baidu.tbadk.data.a();
                    this.ggQ.parserJson(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("lbs_info");
                if (optJSONObject3 != null) {
                    this.ggR = new com.baidu.tbadk.data.g();
                    this.ggR.parserJson(optJSONObject3);
                }
                this.ggN.parserJson(jSONObject.optJSONObject("present"));
                this.YB.setUserMap(this.userMap);
                this.YB.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                JSONArray optJSONArray3 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray3 != null) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        com.baidu.tbadk.data.a aVar = new com.baidu.tbadk.data.a();
                        aVar.parserJson(optJSONArray3.getJSONObject(i3));
                        this.Zi.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("agree");
                if (optJSONObject4 != null) {
                    this.cuw = optJSONObject4.optLong("agree_num", 0L);
                    this.cux = optJSONObject4.optLong("has_agree", 0L) == 1;
                    this.ghd = true;
                } else {
                    this.ghd = false;
                }
                this.ghj = jSONObject.optInt("is_post_visible") == 1;
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
                this.exO = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                this.ghe = post.need_log.intValue() == 1;
                this.ghf = post.img_num_abtest.intValue() == 1;
                this.ggV = new bc();
                this.ggV.parserProtobuf(post.from_forum);
                if (this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) {
                    this.author.parserProtobuf(post.author);
                }
                if (this.author != null && context != null) {
                    this.ggZ = this.author.getUserName() + context.getResources().getString(d.l.somebodys_portrait);
                    this.gha = String.format(TbadkCoreApplication.getInst().getString(d.l.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.ggP = post.is_ntitle.intValue() == 1;
                this.ggJ = post.sub_post_number.intValue();
                this.ggU = new h(post.tpoint_post);
                this.dOb = TbRichTextView.a(context, post.content, true);
                if (this.dOb != null) {
                    this.dOb.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.dOb.fL(this.floor_num);
                    if (this.author != null) {
                        this.dOb.setAuthorId(this.author.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.ggS = subPostList.is_giftpost.intValue() == 1;
                            postData.setUserMap(this.userMap);
                            postData.a(subPostList, context);
                            this.ggK.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.ggO.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.ggQ = new com.baidu.tbadk.data.a();
                    this.ggQ.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.ggR = new com.baidu.tbadk.data.g();
                    this.ggR.a(post.lbs_info);
                }
                this.YW = post.storecount.intValue();
                this.ggN.a(post.present);
                this.YB.setUserMap(this.userMap);
                this.YB.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.eRY = new SmallTailInfo();
                    this.eRY.id = post.signature.signature_id.intValue();
                    this.eRY.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.eRY.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.eRY.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.eRY.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.a aVar = new com.baidu.tbadk.data.a();
                        aVar.a(post.ext_tails.get(i2));
                        this.Zi.add(aVar);
                    }
                }
                this.Zk = post.skin_info;
                this.Zn = post.lego_card;
                this.ghc = post.tpoint_post;
                if (post.agree != null) {
                    this.ghd = true;
                    this.cux = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.cuw = post.agree.agree_num.longValue();
                    } else {
                        this.cuw = 0L;
                    }
                } else {
                    this.ghd = false;
                }
                this.ghj = post.is_post_visible.intValue() == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int eQf;

        public CustomForegroundColorSpan(int i) {
            super(aj.getColor(i));
            this.eQf = i;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aj.getColor(this.eQf));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> ghp;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.ghp = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aj.getColor(d.e.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.ghp != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.ghp.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String bX(Context context) {
        ArrayList<TbRichTextData> Ix;
        if (this.dOb == null || (Ix = this.dOb.Ix()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = Ix.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.IE().toString());
            } else if (next.getType() == 17) {
                String str = next.II().mGifInfo.mSharpText;
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

    public PreLoadImageInfo brv() {
        ArrayList<TbRichTextData> Ix;
        if (this.dOb != null && (Ix = this.dOb.Ix()) != null) {
            Iterator<TbRichTextData> it = Ix.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.ID().getWidth();
                    preLoadImageInfo.height = next.ID().getHeight();
                    preLoadImageInfo.imgUrl = next.ID().IR();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                }
            }
            return null;
        }
        return null;
    }

    public String brw() {
        j bqS;
        PreLoadImageInfo brv = brv();
        if (brv != null && !StringUtils.isNull(brv.imgUrl)) {
            return brv.imgUrl;
        }
        if (this.ggU != null && (bqS = this.ggU.bqS()) != null && !StringUtils.isNull(bqS.bqY())) {
            return bqS.bqY();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> Ix;
        if (this.dOb == null || (Ix = this.dOb.Ix()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = Ix.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.ID().getWidth();
                preLoadImageInfo.height = next.ID().getHeight();
                preLoadImageInfo.imgUrl = next.ID().IR();
                preLoadImageInfo.procType = 17;
                arrayList.add(preLoadImageInfo);
            } else if (next.II() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.II().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.II().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.II();
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
        if (this.ggG == 52) {
            return ggD;
        }
        if (this.ggG == 2) {
            return ggv;
        }
        if (this.ggG == 1) {
            return Zl;
        }
        if (this.ggG == 36) {
            return ggw;
        }
        if (this.ggG == 40 || this.ggG == 50) {
            return XZ;
        }
        if (this.ggG == 41) {
            return ggA;
        }
        if (this.ggG == 53) {
            return ggE;
        }
        if (brq() == 1) {
            return ggt;
        }
        return ggu;
    }

    public void setPostType(int i) {
        this.ggG = i;
    }

    public aq brx() {
        return this.ggN;
    }

    public void a(aq aqVar) {
        this.ggN = aqVar;
    }

    public h bry() {
        return this.ggU;
    }

    public com.baidu.tbadk.widget.richText.e IH() {
        if (this.ggY != null) {
            return this.ggY;
        }
        if (this.dOb != null && v.t(this.dOb.Ix()) > 0) {
            Iterator<TbRichTextData> it = this.dOb.Ix().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.ggY = next.IH();
                    return this.ggY;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo IF() {
        if (this.anG != null) {
            return this.anG;
        }
        if (this.dOb != null && v.t(this.dOb.Ix()) > 0) {
            Iterator<TbRichTextData> it = this.dOb.Ix().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.anG = next.IF();
                    return this.anG;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.tbadk.data.a> brz() {
        return this.Zi;
    }

    public String brA() {
        return this.ggZ;
    }

    public String brB() {
        return this.gha;
    }

    public String sj() {
        return this.Zn;
    }

    public void sm() {
        if (this.YM == 0) {
            this.YM = 1;
        }
    }

    public long brC() {
        return this.cuw;
    }

    public void cM(long j) {
        this.cuw = j;
    }

    public boolean brD() {
        return this.cux;
    }

    public void mB(boolean z) {
        this.cux = z;
    }

    public bc brE() {
        return this.ggV;
    }
}
