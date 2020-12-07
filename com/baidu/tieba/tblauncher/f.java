package com.baidu.tieba.tblauncher;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes22.dex */
public class f {
    public static void D(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("is_new_schema");
            if (!TextUtils.isEmpty(queryParameter) && queryParameter.equals("1")) {
                G(uri);
                return;
            }
            String queryParameter2 = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter2) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter2) || "tbShareH5".equals(queryParameter2) || "wise".equals(queryParameter2) || "zhongjianye".equals(queryParameter2)) {
                String queryParameter3 = uri.getQueryParameter("obj_locate");
                String queryParameter4 = uri.getQueryParameter("obj_type");
                String queryParameter5 = uri.getQueryParameter("obj_param1");
                String queryParameter6 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter7 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM3);
                String queryParameter8 = uri.getQueryParameter("tid");
                String queryParameter9 = uri.getQueryParameter("kw");
                String queryParameter10 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.exd);
                String queryParameter11 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.exe);
                String queryParameter12 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.exf);
                String queryParameter13 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.exg);
                String queryParameter14 = uri.getQueryParameter("obj_name");
                String queryParameter15 = uri.getQueryParameter("eqid");
                ar arVar = new ar("c13561");
                arVar.dY("obj_locate", queryParameter3);
                arVar.dY("obj_type", queryParameter4);
                arVar.dY("obj_param1", queryParameter5);
                arVar.dY(TiebaInitialize.Params.OBJ_PARAM2, queryParameter6);
                arVar.dY(TiebaInitialize.Params.OBJ_PARAM3, queryParameter7);
                arVar.dY("tid", queryParameter8);
                arVar.dY("fname", queryParameter9);
                arVar.dY(com.baidu.tbadk.BdToken.f.exd, queryParameter10);
                arVar.dY(com.baidu.tbadk.BdToken.f.exe, queryParameter11);
                arVar.dY(com.baidu.tbadk.BdToken.f.exf, queryParameter12);
                arVar.dY(com.baidu.tbadk.BdToken.f.exg, queryParameter13);
                arVar.dY("obj_source", queryParameter2);
                arVar.dY("obj_name", queryParameter14);
                arVar.dY("query", queryParameter15);
                TiebaStatic.log(arVar);
            }
        }
    }

    public static void E(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("is_new_schema");
            if (!TextUtils.isEmpty(queryParameter) && queryParameter.equals("1")) {
                ar arVar = new ar("c13998");
                arVar.dY("obj_source", uri.getQueryParameter("obj_source"));
                arVar.dY("obj_locate", uri.getQueryParameter("obj_locate"));
                arVar.dY("obj_type", uri.getQueryParameter("obj_type"));
                arVar.dY("obj_param1", uri.getQueryParameter("obj_param1"));
                TiebaStatic.log(arVar);
            }
        }
    }

    public static void F(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("is_new_schema");
            if (!TextUtils.isEmpty(queryParameter) && queryParameter.equals("1")) {
                G(uri);
                return;
            }
            String queryParameter2 = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter2) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter2) || "tbShareH5".equals(queryParameter2) || "wise".equals(queryParameter2) || "PC".equals(queryParameter2) || "zhongjianye".equals(queryParameter2)) {
                String queryParameter3 = uri.getQueryParameter("obj_locate");
                String queryParameter4 = uri.getQueryParameter("obj_type");
                String queryParameter5 = uri.getQueryParameter("obj_param1");
                String queryParameter6 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter7 = uri.getQueryParameter("kw");
                String queryParameter8 = uri.getQueryParameter("obj_name");
                String queryParameter9 = uri.getQueryParameter("fname");
                ar arVar = new ar("c13561");
                arVar.dY("obj_locate", queryParameter3);
                arVar.dY("obj_type", queryParameter4);
                arVar.dY("obj_param1", queryParameter5);
                arVar.dY(TiebaInitialize.Params.OBJ_PARAM2, queryParameter6);
                arVar.dY("fname", queryParameter7);
                arVar.dY("obj_source", queryParameter2);
                arVar.dY("obj_name", queryParameter8);
                arVar.dY("fname", queryParameter9);
                TiebaStatic.log(arVar);
            }
        }
    }

    private static void G(Uri uri) {
        String queryParameter = uri.getQueryParameter("obj_source");
        String queryParameter2 = uri.getQueryParameter("obj_locate");
        String queryParameter3 = uri.getQueryParameter("obj_type");
        String queryParameter4 = uri.getQueryParameter("obj_param1");
        ar arVar = new ar("c13998");
        arVar.dY("obj_source", queryParameter);
        arVar.dY("obj_locate", queryParameter2);
        arVar.dY("obj_type", queryParameter3);
        arVar.dY("obj_param1", queryParameter4);
        TiebaStatic.log(arVar);
    }

    public static void H(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter) || "zhongjianye".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter("kw");
                String queryParameter7 = uri.getQueryParameter("obj_name");
                String queryParameter8 = uri.getQueryParameter("topic_id");
                ar arVar = new ar("c13561");
                arVar.dY("obj_locate", queryParameter2);
                arVar.dY("obj_type", queryParameter3);
                arVar.dY("obj_param1", queryParameter4);
                arVar.dY(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                arVar.dY("fname", queryParameter6);
                arVar.dY("obj_source", queryParameter);
                arVar.dY("obj_name", queryParameter7);
                arVar.dY("topic_id", queryParameter8);
                TiebaStatic.log(arVar);
            }
        }
    }

    public static void I(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter) || "zhongjianye".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter("obj_name");
                ar arVar = new ar("c13561");
                arVar.dY("obj_locate", queryParameter2);
                arVar.dY("obj_type", queryParameter3);
                arVar.dY("obj_param1", queryParameter4);
                arVar.dY(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                arVar.dY("obj_source", queryParameter);
                arVar.dY("obj_name", queryParameter6);
                TiebaStatic.log(arVar);
            }
        }
    }

    public static void J(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter) || "PC".equals(queryParameter) || "zhongjianye".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                uri.getQueryParameter("kw");
                String queryParameter6 = uri.getQueryParameter("obj_name");
                uri.getQueryParameter("fname");
                ar arVar = new ar("c13561");
                arVar.dY("obj_locate", queryParameter2);
                arVar.dY("obj_type", queryParameter3);
                arVar.dY("obj_param1", queryParameter4);
                arVar.dY(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                arVar.dY("obj_source", queryParameter);
                arVar.dY("obj_name", queryParameter6);
                TiebaStatic.log(arVar);
            }
        }
    }
}
