package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.HeadItem;
import tbclient.Item;
import tbclient.PbContent;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes.dex */
public class PostData implements com.baidu.adp.widget.ListView.n, ah {
    @Deprecated
    private String authorId;
    private String bimg_url;
    private List<HeadItem> eQb;
    private SkinInfo eTX;
    private OriginalThreadInfo eUD;
    private String eUa;
    private Item eVx;
    private TbRichTextVoiceInfo fmD;
    public int isAuthorView;
    private String lMS;
    public int locate;
    private SmallTailInfo mkk;
    public List<PbContent> nAb;
    public Item nAd;
    private i nzA;
    private bx nzB;
    public boolean nzD;
    private com.baidu.tbadk.widget.richText.i nzE;
    private String nzF;
    private String nzG;
    private TPointPost nzH;
    public int nzK;
    public boolean nzN;
    public AlaLiveInfoCoreData nzQ;
    private boolean nzU;
    public ar nzY;
    private String nzl;
    private ArrayList<PostData> nzp;
    private com.baidu.tbadk.data.c nzw;
    private com.baidu.tbadk.data.g nzx;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId nzc = BdUniqueId.gen();
    public static final BdUniqueId nzd = BdUniqueId.gen();
    public static final BdUniqueId eTY = BdUniqueId.gen();
    public static final BdUniqueId eSf = BdUniqueId.gen();
    public static final BdUniqueId eSl = BdUniqueId.gen();
    public static final BdUniqueId nze = BdUniqueId.gen();
    public static final BdUniqueId nzf = BdUniqueId.gen();
    public static final BdUniqueId nzg = BdUniqueId.gen();
    public static final BdUniqueId nzh = BdUniqueId.gen();
    public static final BdUniqueId nzi = BdUniqueId.gen();
    public static boolean nzj = false;
    private int nzk = 0;
    private boolean nzq = false;
    private ArrayList<PostData> nzr = null;
    private TbRichText nzs = null;
    private boolean nzv = false;
    private boolean nzy = false;
    private boolean nzz = false;
    public boolean nzC = false;
    public int eTx = 0;
    private boolean nzI = false;
    public boolean jrd = false;
    public boolean nzJ = false;
    public boolean nzL = false;
    public boolean nzM = true;
    public boolean nzO = false;
    public boolean nzP = false;
    private boolean nzR = false;
    private int nzS = 0;
    private boolean nzT = true;
    public boolean nzV = false;
    public boolean nzW = false;
    public boolean nzX = false;
    public boolean nzZ = false;
    public boolean nAa = false;
    int nAc = com.baidu.tbadk.a.d.bjk();
    private b nAe = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.nzY != null) {
                ar bsQ = PostData.this.nzY.bsQ();
                bsQ.delete("obj_locate");
                bsQ.aq("obj_locate", 7);
                TiebaStatic.log(bsQ);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData eTa = new MetaData();
    private ArrayList<l> nzm = new ArrayList<>();
    private ArrayList<l> nzn = new ArrayList<>();
    private int nzo = 0;
    private int eTI = 0;
    private PraiseData eTl = new PraiseData();
    private bb nzt = new bb();
    private c nzu = new c();
    private ArrayList<com.baidu.tbadk.data.c> eTU = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.nzp = null;
        this.nzK = 0;
        this.nzp = new ArrayList<>();
        this.nzK = 0;
    }

    public void yr(boolean z) {
        this.nzU = z;
    }

    public boolean dNG() {
        return this.nzU;
    }

    public ArrayList<PostData> dNH() {
        return this.nzr;
    }

    public void dNI() {
        this.nzr.clear();
        this.nzr = null;
        this.nzq = false;
    }

    public void y(PostData postData) {
        if (postData != null) {
            if (this.nzr == null) {
                this.nzr = new ArrayList<>();
                if (y.getCount(this.nzp) > this.nAc) {
                    this.nzr.addAll(y.subList(this.nzp, 0, this.nAc));
                } else {
                    this.nzr.addAll(this.nzp);
                }
            }
            this.nzr.add(postData);
        }
    }

    public void z(PostData postData) {
        if (postData != null && this.nzp != null) {
            this.nzp.add(postData);
            dNM();
        }
    }

    public void Tx(String str) {
        if (this.nzr != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.nzr.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.nzr.remove(next);
                    return;
                }
            }
        }
    }

    public void ys(boolean z) {
        this.nzT = z;
    }

    public boolean dNJ() {
        return this.nzT;
    }

    public void yt(boolean z) {
        this.nzq = z;
    }

    public boolean dNK() {
        return this.nzq;
    }

    public ArrayList<PostData> dNL() {
        return this.nzp;
    }

    public void dNM() {
        this.nzo++;
    }

    public void dNN() {
        this.nzo--;
    }

    public void JI(int i) {
        this.nzo = i;
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

    public long getTid() {
        return this.tid;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int dNO() {
        return this.floor_num;
    }

    public void JJ(int i) {
        this.floor_num = i;
    }

    public boolean dNP() {
        return this.nzz;
    }

    public void yu(boolean z) {
        this.nzz = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = au.getFormatTime(j);
    }

    public MetaData bnS() {
        return this.eTa;
    }

    public void a(MetaData metaData) {
        this.eTa = metaData;
    }

    public void a(PraiseData praiseData) {
        this.eTl = praiseData;
    }

    public TbRichText dNQ() {
        return this.nzs;
    }

    public void c(TbRichText tbRichText) {
        this.nzs = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo dtB() {
        return this.mkk;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.mkk = smallTailInfo;
    }

    public com.baidu.tbadk.data.g dNR() {
        return this.nzx;
    }

    public SkinInfo bon() {
        return this.eTX;
    }

    public void yv(boolean z) {
        this.nzR = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.nzs != null && this.nzs.bHD() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            String str3 = null;
            if (z) {
                str = " 楼主";
            } else {
                if (this.eTa != null && this.eTa.getIs_bawu() == 1) {
                    if (this.nzU) {
                        str = " 品牌官";
                    } else if (Config.BAWU_TYPE_MANAGER.equals(this.eTa.getBawu_type())) {
                        str = " 吧主";
                    } else if (Config.BAWU_TYPE_ASSIST.equals(this.eTa.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.eTa.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.eTa.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = bnS().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.d.mw().loadResourceFromMemery(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.e.d.mw().a(next.getIcon(), 21, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.e.c
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((AnonymousClass1) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.isValidNow()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.nzs.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.h(aVar);
                        }
                    }, 0, 1);
                    cVar.setEmptyBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.eTa.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.eTa.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.eTa != null) {
                spannableString = new SpannableString(sb2 + this.eTa.getName_show() + str + "：");
                String userName = this.eTa.getUserName();
                str2 = this.eTa.getUserId();
                str3 = userName;
            } else {
                spannableString = new SpannableString(sb2 + str + "：");
                str2 = null;
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.eTa.getSealPrefix())) {
                Bitmap bitmap = ap.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.eTa.getSealPrefix().length() + 1;
                spannableString.setSpan(iVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str3, str2, this.nAe), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.eTa != null && this.eTa.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.b g = g(z, this.eTa != null && this.eTa.getIs_bawu() == 1, str);
                if (g != null) {
                    if (this.eTa != null) {
                        int i3 = 0;
                        if (this.eTa.getName_show() != null) {
                            i3 = this.eTa.getName_show().length();
                        }
                        spannableString.setSpan(g, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(g, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> bHD = this.nzs.bHD();
            if (bHD != null && bHD.size() > 0) {
                TbRichTextData tbRichTextData2 = bHD.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.bHK() != null) {
                    if (this.nzR) {
                        int indexOf = tbRichTextData2.bHK().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.bHK().delete(0, indexOf + 1);
                        }
                        this.nzR = false;
                    }
                    tbRichTextData2.sm(sb.length());
                    tbRichTextData2.bHK().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= bHD.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (bHD.get(i5) == null || bHD.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo bHL = bHD.get(i5).bHL();
                            bHD.remove(i5);
                            tbRichTextVoiceInfo = bHL;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.sm(sb.length());
                    tbRichTextData.p(spannableString);
                    bHD.add(0, tbRichTextData);
                }
            }
            this.nzV = true;
        }
    }

    private com.baidu.tbadk.core.view.b g(boolean z, boolean z2, String str) {
        if (z || z2) {
            Context context = TbadkCoreApplication.getInst().getContext();
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.L_X01);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10);
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds12);
            int dimens5 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds40);
            if (" 楼主".equals(str)) {
                com.baidu.tbadk.core.view.b bVar = new com.baidu.tbadk.core.view.b(dimens, -1, R.color.CAM_X0302, dimens3, R.color.CAM_X0302, dimens4, dimens5);
                bVar.pm(dimens2);
                bVar.jW(false);
                bVar.BF(str);
                return bVar;
            } else if (" 吧主".equals(str) || " 小吧主".equals(str) || " 品牌官".equals(str)) {
                com.baidu.tbadk.core.view.b bVar2 = new com.baidu.tbadk.core.view.b(dimens, -1, R.color.CAM_X0302, dimens3, R.color.CAM_X0101, dimens4, dimens5);
                bVar2.pm(dimens2);
                bVar2.jW(true);
                bVar2.BF(str);
                return bVar2;
            } else {
                return null;
            }
        }
        return null;
    }

    protected Drawable h(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (aVar == null || (rawBitmap = aVar.getRawBitmap()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(rawBitmap);
        bitmapDrawable.setBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
        return bitmapDrawable;
    }

    public int dNS() {
        return this.nzo;
    }

    public void gU(Context context) {
        int type;
        int i;
        if (this.nzm != null) {
            int i2 = -1;
            int size = this.nzn.size();
            if (size > 0) {
                try {
                    i2 = this.nzn.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i3 = 0;
            int i4 = i2;
            while (i3 < this.nzm.size()) {
                l lVar = this.nzm.get(i3);
                if (l.dt(i4, lVar.getType())) {
                    this.nzn.get(size - 1).b(lVar.gT(context));
                    i = size;
                    type = i4;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.nzn.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.gT(context));
                        this.nzn.add(lVar2);
                        type = 0;
                    }
                    i = size + 1;
                }
                i3++;
                size = i;
                i4 = type;
            }
        }
    }

    public void gV(Context context) {
        try {
            if (this.nzs != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.nzs.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.nzn == null || this.nzn.size() == 0) {
                gU(context);
            }
            ArrayList<l> arrayList = this.nzn;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.dNu() != null) {
                            sb.append((CharSequence) next.dNu());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String CT = TbFaceManager.bCR().CT(next.getText());
                        if (CT != null) {
                            sb.append("[");
                            sb.append(CT);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !au.isEmpty(next.dNt())) {
                        sb.append("[").append(next.dNt()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                if (clipboardManager2.getText() != null) {
                }
            }
        } catch (Exception e) {
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
                this.date = au.getFormatTime(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.nzy = subPostList.is_giftpost.intValue() == 1;
                this.agreeData.postId = this.id;
                this.agreeData.parseProtobuf(subPostList.agree);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.eTa = metaData;
                }
                if (this.eTa.getUserId() == null || this.eTa.getUserId().length() <= 0 || this.eTa.getUserId().equals("0")) {
                    this.eTa = metaData2;
                }
                this.nzs = TbRichTextView.a(context, subPostList.content, z);
                if (this.nzs != null) {
                    this.nzs.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                }
                this.isAuthorView = subPostList.is_author_view.intValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Post post, Context context) {
        TbRichTextData tbRichTextData;
        int i;
        MetaData metaData;
        if (post != null) {
            try {
                this.id = String.valueOf(post.id);
                this.tid = post.tid.longValue();
                this.title = post.title;
                this.floor_num = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = au.getFormatTime(this.time);
                this.nzl = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.eTa = metaData;
                }
                this.jrd = post.need_log.intValue() == 1;
                this.nzJ = post.img_num_abtest.intValue() == 1;
                this.nzB = new bx();
                this.nzB.parserProtobuf(post.from_forum);
                if (this.eTa.getUserId() == null || this.eTa.getUserId().length() <= 0 || this.eTa.getUserId().equals("0")) {
                    this.eTa.parserProtobuf(post.author);
                }
                if (this.eTa != null && context != null) {
                    this.nzF = this.eTa.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.nzG = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.eTa.getLevel_id()));
                }
                this.nzv = post.is_ntitle.intValue() == 1;
                this.nzo = post.sub_post_number.intValue();
                this.nzA = new i(post.tpoint_post);
                List<PbContent> list = post.content;
                this.nAb = post.content;
                this.nzZ = post.is_wonderful_post.intValue() == 1;
                this.nzW = post.is_top_agree_post.intValue() == 1;
                this.eQb = post.item_star;
                if (post.item != null && post.item.item_id.longValue() != 0) {
                    this.eVx = post.item;
                }
                if (this.eVx == null && post.outer_item != null && post.outer_item.item_id.longValue() > 0 && com.baidu.tbadk.a.d.bjB()) {
                    this.nAd = post.outer_item;
                }
                this.nzs = TbRichTextView.a(context, list, String.valueOf(post.tid), true);
                if (this.nzs != null) {
                    this.nzs.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                    this.nzs.sl(this.floor_num);
                    if (this.eTa != null) {
                        this.nzs.setAuthorId(this.eTa.getUserId());
                    }
                    int count = y.getCount(this.eQb);
                    if (this.floor_num == 1 && count != 0 && this.eQb != null) {
                        ArrayList<TbRichTextData> bHD = this.nzs.bHD();
                        if (count == 1) {
                            TbRichTextData tbRichTextData2 = (TbRichTextData) y.getItem(bHD, 0);
                            if (tbRichTextData2 == null || tbRichTextData2.getType() != 1) {
                                TbRichTextData tbRichTextData3 = new TbRichTextData(1);
                                y.add(bHD, 0, tbRichTextData3);
                                tbRichTextData = tbRichTextData3;
                            } else {
                                tbRichTextData = tbRichTextData2;
                            }
                            HeadItem headItem = (HeadItem) y.getItem(this.eQb, 0);
                            if (headItem != null) {
                                try {
                                    i = Integer.parseInt(headItem.content);
                                } catch (NumberFormatException e) {
                                    i = 0;
                                }
                                tbRichTextData.q(com.baidu.tbadk.widget.richText.e.I(i, false));
                            }
                        } else {
                            for (int size = this.eQb.size() - 1; size >= 0; size--) {
                                HeadItem headItem2 = this.eQb.get(size);
                                if (headItem2 != null) {
                                    a(bHD, headItem2);
                                }
                            }
                        }
                    }
                    if (this.floor_num == 1 && this.eVx != null) {
                        TbRichTextData tbRichTextData4 = new TbRichTextData(1281);
                        tbRichTextData4.a(new TbRichTextEvaluateItemInfo(this.eVx));
                        y.add(this.nzs.bHD(), tbRichTextData4);
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list2 = subPost.sub_post_list;
                    if (list2.size() > 0) {
                        for (int i2 = 0; i2 < list2.size(); i2++) {
                            SubPostList subPostList = list2.get(i2);
                            PostData postData = new PostData();
                            postData.nzy = subPostList.is_giftpost.intValue() == 1;
                            postData.agreeData.parseProtobuf(subPostList.agree);
                            postData.setUserMap(this.userMap);
                            postData.yr(this.nzU);
                            postData.a(subPostList, context);
                            this.nzp.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.nzu.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.nzw = new com.baidu.tbadk.data.c();
                    this.nzw.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.nzx = new com.baidu.tbadk.data.g();
                    this.nzx.a(post.lbs_info);
                }
                this.eTI = post.storecount.intValue();
                this.nzt.a(post.present);
                this.eTl.setUserMap(this.userMap);
                this.eTl.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.mkk = new SmallTailInfo();
                    this.mkk.id = post.signature.signature_id.intValue();
                    this.mkk.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.mkk.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.mkk.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.mkk.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i3 = 0; i3 != post.ext_tails.size(); i3++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i3));
                        this.eTU.add(cVar);
                    }
                }
                this.eTX = post.skin_info;
                this.eUa = post.lego_card;
                this.nzH = post.tpoint_post;
                if (post.agree != null) {
                    this.nzI = true;
                    this.agreeData.postId = this.id;
                    this.agreeData.parseProtobuf(post.agree);
                } else {
                    this.nzI = false;
                }
                this.nzP = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.eUD = new OriginalThreadInfo();
                    this.eUD.a(post.origin_thread_info);
                } else {
                    this.eUD = null;
                }
                this.nzS = post.is_fold.intValue();
                this.lMS = post.fold_tip;
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(List<TbRichTextData> list, HeadItem headItem) {
        int i;
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new SpannableString(headItem.name + ": " + (headItem.type.intValue() == 1 ? headItem.content : " ")));
        if (headItem.type.intValue() == 2) {
            try {
                i = Integer.parseInt(headItem.content);
            } catch (NumberFormatException e) {
                i = 0;
            }
            spannableStringBuilder.append((CharSequence) com.baidu.tbadk.widget.richText.e.I(i, true));
        }
        tbRichTextData.p(spannableStringBuilder);
        y.add(list, 0, tbRichTextData);
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int mColorId;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(this.mColorId));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private String mId;
        private String mName;
        private SoftReference<Context> nAk;
        private b nAl;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.nAk = new SoftReference<>(context);
            this.nAl = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(R.color.CAM_X0108));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(true);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.nAk != null && this.nAk.get() != null) {
                if (this.nAl != null) {
                    this.nAl.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.nAk.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String gW(Context context) {
        ArrayList<TbRichTextData> bHD;
        if (this.nzs == null || (bHD = this.nzs.bHD()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = bHD.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.bHK().toString());
            } else if (next.getType() == 17) {
                String str = next.bHO().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(R.string.editor_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(R.string.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(R.string.video_title_str) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public String dNT() {
        ArrayList<TbRichTextData> bHD;
        String str;
        if (this.nzs == null || (bHD = this.nzs.bHD()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = bHD.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.bHK().toString());
                } else if (next.getType() == 17) {
                    if (next.bHO() != null && next.bHO().mGifInfo != null && (str = next.bHO().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo dNU() {
        ArrayList<TbRichTextData> bHD;
        if (this.nzs != null && (bHD = this.nzs.bHD()) != null) {
            Iterator<TbRichTextData> it = bHD.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.bHJ().getWidth();
                    preLoadImageInfo.height = next.bHJ().getHeight();
                    preLoadImageInfo.imgUrl = next.bHJ().bHW();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.bHP().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.bHP().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.bHP().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String dNV() {
        k dNr;
        PreLoadImageInfo dNU = dNU();
        if (dNU != null && !StringUtils.isNull(dNU.imgUrl)) {
            return dNU.imgUrl;
        }
        if (this.nzA != null && (dNr = this.nzA.dNr()) != null && !StringUtils.isNull(dNr.dNs())) {
            return dNr.dNs();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> bHD;
        if (this.nzs == null || (bHD = this.nzs.bHD()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = bHD.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.bHJ().getWidth();
                preLoadImageInfo.height = next.bHJ().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.bHJ().bIb()) {
                    preLoadImageInfo.imgUrl = next.bHJ().bHX();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.bHJ().bHW();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.bHO() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.bHO().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.bHO().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.bHO();
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
        if (this.eTa == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.eTa.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (this.nzk == 52) {
            return nzg;
        }
        if (this.nzk == 1) {
            return eTY;
        }
        if (this.nzk == 36) {
            return eSf;
        }
        if (this.nzk == 40 || this.nzk == 50) {
            return eSl;
        }
        if (this.nzk == 41) {
            return nze;
        }
        if (this.nzk == 53) {
            return nzh;
        }
        if (dNO() == 1) {
            return nzc;
        }
        return nzd;
    }

    public void setPostType(int i) {
        this.nzk = i;
    }

    public bb dNW() {
        return this.nzt;
    }

    public void a(bb bbVar) {
        this.nzt = bbVar;
    }

    public i dNX() {
        return this.nzA;
    }

    public com.baidu.tbadk.widget.richText.i bHN() {
        if (this.nzE != null) {
            return this.nzE;
        }
        if (this.nzs != null && y.getCount(this.nzs.bHD()) > 0) {
            Iterator<TbRichTextData> it = this.nzs.bHD().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.nzE = next.bHN();
                    return this.nzE;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo bHL() {
        if (this.fmD != null) {
            return this.fmD;
        }
        if (this.nzs != null && y.getCount(this.nzs.bHD()) > 0) {
            Iterator<TbRichTextData> it = this.nzs.bHD().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.fmD = next.bHL();
                    return this.fmD;
                }
            }
        }
        return null;
    }

    public String dNY() {
        return this.nzF;
    }

    public String bpd() {
        return this.eUa;
    }

    public void bpf() {
        if (this.eTx == 0) {
            this.eTx = 1;
        }
    }

    public long bpt() {
        return this.agreeData.disAgreeNum;
    }

    public int bpv() {
        return this.agreeData.agreeType;
    }

    public AgreeData bpL() {
        return this.agreeData;
    }

    public OriginalThreadInfo dNZ() {
        return this.eUD;
    }

    public void h(OriginalThreadInfo originalThreadInfo) {
        this.eUD = originalThreadInfo;
    }

    public int dOa() {
        return this.nzS;
    }

    public String dlA() {
        return this.lMS;
    }

    public Item bpY() {
        return this.eVx;
    }

    public List<HeadItem> bpZ() {
        return this.eQb;
    }
}
