package com.baidu.tieba.tblauncher;

import android.net.Uri;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes9.dex */
public class f {
    public static void C(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM3);
                String queryParameter7 = uri.getQueryParameter("tid");
                String queryParameter8 = uri.getQueryParameter("kw");
                String queryParameter9 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.dvt);
                String queryParameter10 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.dvu);
                String queryParameter11 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.dvv);
                String queryParameter12 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.dvw);
                String queryParameter13 = uri.getQueryParameter("obj_name");
                String queryParameter14 = uri.getQueryParameter("eqid");
                an anVar = new an("c13561");
                anVar.dh("obj_locate", queryParameter2);
                anVar.dh("obj_type", queryParameter3);
                anVar.dh("obj_param1", queryParameter4);
                anVar.dh(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                anVar.dh(TiebaInitialize.Params.OBJ_PARAM3, queryParameter6);
                anVar.dh("tid", queryParameter7);
                anVar.dh("fname", queryParameter8);
                anVar.dh(com.baidu.tbadk.BdToken.f.dvt, queryParameter9);
                anVar.dh(com.baidu.tbadk.BdToken.f.dvu, queryParameter10);
                anVar.dh(com.baidu.tbadk.BdToken.f.dvv, queryParameter11);
                anVar.dh(com.baidu.tbadk.BdToken.f.dvw, queryParameter12);
                anVar.dh("obj_source", queryParameter);
                anVar.dh("obj_name", queryParameter13);
                anVar.dh("query", queryParameter14);
                TiebaStatic.log(anVar);
            }
        }
    }

    public static void D(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter("kw");
                String queryParameter7 = uri.getQueryParameter("obj_name");
                String queryParameter8 = uri.getQueryParameter("fname");
                an anVar = new an("c13561");
                anVar.dh("obj_locate", queryParameter2);
                anVar.dh("obj_type", queryParameter3);
                anVar.dh("obj_param1", queryParameter4);
                anVar.dh(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                anVar.dh("fname", queryParameter6);
                anVar.dh("obj_source", queryParameter);
                anVar.dh("obj_name", queryParameter7);
                anVar.dh("fname", queryParameter8);
                TiebaStatic.log(anVar);
            }
        }
    }

    public static void E(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter("kw");
                String queryParameter7 = uri.getQueryParameter("obj_name");
                String queryParameter8 = uri.getQueryParameter("topic_id");
                an anVar = new an("c13561");
                anVar.dh("obj_locate", queryParameter2);
                anVar.dh("obj_type", queryParameter3);
                anVar.dh("obj_param1", queryParameter4);
                anVar.dh(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                anVar.dh("fname", queryParameter6);
                anVar.dh("obj_source", queryParameter);
                anVar.dh("obj_name", queryParameter7);
                anVar.dh("topic_id", queryParameter8);
                TiebaStatic.log(anVar);
            }
        }
    }

    public static void F(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter("obj_name");
                an anVar = new an("c13561");
                anVar.dh("obj_locate", queryParameter2);
                anVar.dh("obj_type", queryParameter3);
                anVar.dh("obj_param1", queryParameter4);
                anVar.dh(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                anVar.dh("obj_source", queryParameter);
                anVar.dh("obj_name", queryParameter6);
                TiebaStatic.log(anVar);
            }
        }
    }
}
